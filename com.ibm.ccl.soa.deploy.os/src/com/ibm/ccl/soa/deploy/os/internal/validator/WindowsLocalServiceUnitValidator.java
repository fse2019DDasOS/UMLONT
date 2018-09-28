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
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit;

/**
 * Validates {@link WindowsLocalServiceUnit}.
 * <p>
 */
public class WindowsLocalServiceUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link WindowsLocalServiceUnit} instance validator.
	 */
	public WindowsLocalServiceUnitValidator() {
		this(OsPackage.eINSTANCE.getWindowsLocalServiceUnit());
	}

	/**
	 * Construct a {@link WindowsLocalServiceUnit} validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link WindowsLocalServiceUnit}.
	 */
	protected WindowsLocalServiceUnitValidator(EClass unitType) {
		super(unitType);
	}
}
