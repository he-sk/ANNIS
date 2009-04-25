/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.peper.modules.relANNIS.validation;


/**
 * A sample validator interface for {@link de.corpling.peper.modules.relANNIS.RACorpusAnnotation}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RACorpusAnnotationValidator {
	boolean validate();

	boolean validateCorpus_ref(Long value);
	boolean validateNamespace(String value);
	boolean validateName(String value);
	boolean validateValue(String value);
}