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

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link LinuxLocalServiceUnit}.
 * <p>
 */
public class LinuxLocalServiceUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link LinuxLocalServiceUnit} instance validator.
	 */
	public LinuxLocalServiceUnitValidator() {
		this(OsPackage.eINSTANCE.getLinuxLocalServiceUnit());
	}

	/**
	 * Construct a {@link LinuxLocalServiceUnit} validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link LinuxLocalServiceUnit}.
	 */
	protected LinuxLocalServiceUnitValidator(EClass unitType) {
		super(unitType);
	}
}
