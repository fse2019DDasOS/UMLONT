/**
 * <copyright>
 * </copyright>
 *
 * $Id: RedhatLinuxLocalUserValidator.java,v 1.4 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RedhatLinuxLocalUserValidator {
	boolean validate();

	boolean validateAccountDisableAfterDays(String value);

	boolean validateAccountDisableDate(String value);

	boolean validateDaysBeforePasswordMayChange(String value);

	boolean validateLastPasswordChange(String value);

	boolean validatePasswordExpireAfterDays(String value);

	boolean validatePasswordExpireWarningDays(String value);

	boolean validateUserSid(String value);
}
