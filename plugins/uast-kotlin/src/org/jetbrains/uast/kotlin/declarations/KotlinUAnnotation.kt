package org.jetbrains.uast.kotlin

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.uast.*

class KotlinUAnnotation(
        override val psi: KtAnnotationEntry,
        override val containingElement: UElement?
) : UAnnotation {
    private val resolvedAnnotation by lz { psi.analyze()[BindingContext.ANNOTATION, psi] }

    override val qualifiedName: String?
        get() = resolvedAnnotation?.type?.constructor?.declarationDescriptor?.fqNameSafe?.asString()

    override val attributeValues by lz {
        val context = getUastContext()
        psi.valueArguments.map { arg ->
            val name = arg.getArgumentName()?.asName?.asString() ?: ""
            KotlinUNamedExpression(name, this).apply {
                val value = arg.getArgumentExpression()?.let { context.convertElement(it, this) } as? UExpression
                expression = value ?: UastEmptyExpression
            }
        }
    }

    override fun resolve(): PsiClass? {
        val descriptor = resolvedAnnotation?.type?.constructor?.declarationDescriptor ?: return null
        return descriptor.toSource()?.getMaybeLightElement(this) as? PsiClass
    }

    //TODO
    override fun findAttributeValue(name: String?) = findDeclaredAttributeValue(name)

    override fun findDeclaredAttributeValue(name: String?): UExpression? {
        return attributeValues.firstOrNull { it.name == (name ?: "value") }?.expression
    }
}

class KotlinUNamedExpression(override val name: String, override val containingElement: UElement?) : UNamedExpression {
    override lateinit var expression: UExpression

    override val annotations: List<UAnnotation>
        get() = emptyList()

    override val psi: PsiElement?
        get() = null
}
