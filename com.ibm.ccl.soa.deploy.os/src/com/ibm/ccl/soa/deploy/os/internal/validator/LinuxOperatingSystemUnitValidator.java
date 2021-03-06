/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link LinuxOperatingSystemUnit}.
 * <p>
 */
public class LinuxOperatingSystemUnitValidator extends OperatingSystemUnitValidator {

	/**
	 * Construct a validator for {@link LinuxOperatingSystemUnit} instances.
	 */
	public LinuxOperatingSystemUnitValidator() {
		this(OsPackage.eINSTANCE.getLinuxOperatingSystemUnit());
	}

	/**
	 * Construct a validator for {@link LinuxOperatingSystemUnit} subtypes.
	 * 
	 * @param unitType
	 *           a subtype of {@link LinuxOperatingSystemUnit}.
	 */
	protected LinuxOperatingSystemUnitValidator(EClass unitType) {
		super(unitType);
	}
}
