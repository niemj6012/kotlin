/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.psi.stubs.elements;

import com.intellij.psi.tree.TokenSet;
import org.jetbrains.kotlin.psi.*;

import static org.jetbrains.kotlin.KtNodeTypes.SELF_TYPE;

public interface KtStubElementTypes {
    KtFileElementType FILE = new KtFileElementType();

    KtClassElementType CLASS = new KtClassElementType("CLASS");
    KtFunctionElementType FUNCTION = new KtFunctionElementType("FUN");
    KtPropertyElementType PROPERTY = new KtPropertyElementType("PROPERTY");
    KtPropertyAccessorElementType PROPERTY_ACCESSOR = new KtPropertyAccessorElementType("PROPERTY_ACCESSOR");

    KtClassElementType ENUM_ENTRY = new KtClassElementType("ENUM_ENTRY");
    KtObjectElementType OBJECT_DECLARATION = new KtObjectElementType("OBJECT_DECLARATION");
    KtPlaceHolderStubElementType<KtClassInitializer> CLASS_INITIALIZER =
            new KtPlaceHolderStubElementType<KtClassInitializer>("CLASS_INITIALIZER", KtClassInitializer.class);
    KtPlaceHolderStubElementType<KtSecondaryConstructor> SECONDARY_CONSTRUCTOR =
            new KtPlaceHolderStubElementType<KtSecondaryConstructor>("SECONDARY_CONSTRUCTOR", KtSecondaryConstructor.class);
    KtPlaceHolderStubElementType<KtPrimaryConstructor> PRIMARY_CONSTRUCTOR =
            new KtPlaceHolderStubElementType<KtPrimaryConstructor>("PRIMARY_CONSTRUCTOR", KtPrimaryConstructor.class);

    KtParameterElementType VALUE_PARAMETER = new KtParameterElementType("VALUE_PARAMETER");
    KtPlaceHolderStubElementType<KtParameterList> VALUE_PARAMETER_LIST =
            new KtPlaceHolderStubElementType<KtParameterList>("VALUE_PARAMETER_LIST", KtParameterList.class);

    KtTypeParameterElementType TYPE_PARAMETER = new KtTypeParameterElementType("TYPE_PARAMETER");
    KtPlaceHolderStubElementType<KtTypeParameterList> TYPE_PARAMETER_LIST =
            new KtPlaceHolderStubElementType<KtTypeParameterList>("TYPE_PARAMETER_LIST", KtTypeParameterList.class);

    KtAnnotationEntryElementType ANNOTATION_ENTRY = new KtAnnotationEntryElementType("ANNOTATION_ENTRY");
    KtPlaceHolderStubElementType<KtAnnotation> ANNOTATION =
            new KtPlaceHolderStubElementType<KtAnnotation>("ANNOTATION", KtAnnotation.class);

    KtAnnotationUseSiteTargetElementType ANNOTATION_TARGET = new KtAnnotationUseSiteTargetElementType("ANNOTATION_TARGET");

    KtPlaceHolderStubElementType<KtClassBody> CLASS_BODY =
            new KtPlaceHolderStubElementType<KtClassBody>("CLASS_BODY", KtClassBody.class);

    KtPlaceHolderStubElementType<KtImportList> IMPORT_LIST =
            new KtPlaceHolderStubElementType<KtImportList>("IMPORT_LIST", KtImportList.class);

    KtPlaceHolderStubElementType<KtFileAnnotationList> FILE_ANNOTATION_LIST =
            new KtPlaceHolderStubElementType<KtFileAnnotationList>("FILE_ANNOTATION_LIST", KtFileAnnotationList.class);

    KtImportDirectiveElementType IMPORT_DIRECTIVE = new KtImportDirectiveElementType("IMPORT_DIRECTIVE");

    KtPlaceHolderStubElementType<KtPackageDirective> PACKAGE_DIRECTIVE =
            new KtPlaceHolderStubElementType<KtPackageDirective>("PACKAGE_DIRECTIVE", KtPackageDirective.class);

    KtModifierListElementType<KtDeclarationModifierList> MODIFIER_LIST =
            new KtModifierListElementType<KtDeclarationModifierList>("MODIFIER_LIST", KtDeclarationModifierList.class);

    KtPlaceHolderStubElementType<KtTypeConstraintList> TYPE_CONSTRAINT_LIST =
            new KtPlaceHolderStubElementType<KtTypeConstraintList>("TYPE_CONSTRAINT_LIST", KtTypeConstraintList.class);

    KtPlaceHolderStubElementType<KtTypeConstraint> TYPE_CONSTRAINT =
            new KtPlaceHolderStubElementType<KtTypeConstraint>("TYPE_CONSTRAINT", KtTypeConstraint.class);

    KtPlaceHolderStubElementType<KtNullableType> NULLABLE_TYPE =
            new KtPlaceHolderStubElementType<KtNullableType>("NULLABLE_TYPE", KtNullableType.class);

    KtPlaceHolderStubElementType<KtTypeReference> TYPE_REFERENCE =
            new KtPlaceHolderStubElementType<KtTypeReference>("TYPE_REFERENCE", KtTypeReference.class);

    KtUserTypeElementType USER_TYPE = new KtUserTypeElementType("USER_TYPE");
    KtPlaceHolderStubElementType<KtDynamicType> DYNAMIC_TYPE =
            new KtPlaceHolderStubElementType<KtDynamicType>("DYNAMIC_TYPE", KtDynamicType.class);

    KtPlaceHolderStubElementType<KtFunctionType> FUNCTION_TYPE =
            new KtPlaceHolderStubElementType<KtFunctionType>("FUNCTION_TYPE", KtFunctionType.class);

    KtTypeProjectionElementType TYPE_PROJECTION = new KtTypeProjectionElementType("TYPE_PROJECTION");

    KtPlaceHolderStubElementType<KtFunctionTypeReceiver> FUNCTION_TYPE_RECEIVER =
            new KtPlaceHolderStubElementType<KtFunctionTypeReceiver>("FUNCTION_TYPE_RECEIVER", KtFunctionTypeReceiver.class);

    KtNameReferenceExpressionElementType NAME_REFERENCE_EXPRESSION = new KtNameReferenceExpressionElementType("NAME_REFERENCE_EXPRESSION");
    KtDotQualifiedExpressionElementType DOT_QUALIFIED_EXPRESSION = new KtDotQualifiedExpressionElementType("DOT_QUALIFIED_EXPRESSION");
    KtEnumEntrySuperClassReferenceExpressionElementType
            ENUM_ENTRY_SUPERCLASS_REFERENCE_EXPRESSION = new KtEnumEntrySuperClassReferenceExpressionElementType("ENUM_ENTRY_SUPERCLASS_REFERENCE_EXPRESSION");
    KtPlaceHolderStubElementType<KtTypeArgumentList> TYPE_ARGUMENT_LIST =
            new KtPlaceHolderStubElementType<KtTypeArgumentList>("TYPE_ARGUMENT_LIST", KtTypeArgumentList.class);

    KtPlaceHolderStubElementType<KtSuperTypeList> SUPER_TYPE_LIST =
            new KtPlaceHolderStubElementType<KtSuperTypeList>("SUPER_TYPE_LIST", KtSuperTypeList.class);

    KtPlaceHolderStubElementType<KtInitializerList> INITIALIZER_LIST =
            new KtPlaceHolderStubElementType<KtInitializerList>("INITIALIZER_LIST", KtInitializerList.class);

    KtPlaceHolderStubElementType<KtDelegatedSuperTypeEntry> DELEGATED_SUPER_TYPE_ENTRY =
            new KtPlaceHolderStubElementType<KtDelegatedSuperTypeEntry>("DELEGATED_SUPER_TYPE_ENTRY", KtDelegatedSuperTypeEntry.class);

    KtPlaceHolderStubElementType<KtSuperTypeCallEntry> SUPER_TYPE_CALL_ENTRY =
            new KtPlaceHolderStubElementType<KtSuperTypeCallEntry>("SUPER_TYPE_CALL_ENTRY", KtSuperTypeCallEntry.class);
    KtPlaceHolderStubElementType<KtSuperTypeEntry> SUPER_TYPE_ENTRY =
            new KtPlaceHolderStubElementType<KtSuperTypeEntry>("SUPER_TYPE_ENTRY", KtSuperTypeEntry.class);
    KtPlaceHolderStubElementType<KtConstructorCalleeExpression> CONSTRUCTOR_CALLEE =
            new KtPlaceHolderStubElementType<KtConstructorCalleeExpression>("CONSTRUCTOR_CALLEE", KtConstructorCalleeExpression.class);

    KtScriptElementType SCRIPT = new KtScriptElementType("SCRIPT");

    TokenSet DECLARATION_TYPES =
            TokenSet.create(CLASS, OBJECT_DECLARATION, FUNCTION, PROPERTY, CLASS_INITIALIZER, SECONDARY_CONSTRUCTOR, ENUM_ENTRY);

    TokenSet SUPER_TYPE_LIST_ENTRIES = TokenSet.create(DELEGATED_SUPER_TYPE_ENTRY, SUPER_TYPE_CALL_ENTRY, SUPER_TYPE_ENTRY);

    TokenSet TYPE_ELEMENT_TYPES = TokenSet.create(USER_TYPE, NULLABLE_TYPE, FUNCTION_TYPE, DYNAMIC_TYPE, SELF_TYPE);

    TokenSet INSIDE_DIRECTIVE_EXPRESSIONS = TokenSet.create(NAME_REFERENCE_EXPRESSION, DOT_QUALIFIED_EXPRESSION);
}
