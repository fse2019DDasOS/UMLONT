/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.validation;


/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.osgi.BundleComponent}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface BundleComponentValidator {
	boolean validate();

	boolean validateActivator(String value);
	boolean validateEclipseLazyStart(boolean value);
	boolean validateLocalization(String value);
	boolean validateManifestVersion(String value);
	boolean validateSingleton(boolean value);
	boolean validateVendor(String value);
}
