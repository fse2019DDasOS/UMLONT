/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinuxOperatingSystemValidator.java,v 1.4 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

import com.ibm.ccl.soa.deploy.os.ArchitectureBusType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface LinuxOperatingSystemValidator {
	boolean validate();

	boolean validateArchitectureBus(ArchitectureBusType value);

	boolean validateKernelRelease(String value);

	boolean validateLocale(String value);

	boolean validateTimeZone(String value);
}
