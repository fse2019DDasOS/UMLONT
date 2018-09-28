/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.validation;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.server.ArchitectureWidthType;
import com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.server.Server}. This doesn't
 * really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ServerValidator {
	boolean validate();

	boolean validateAutoStart(boolean value);

	boolean validateCpuArchitecture(String value);

	boolean validateCpuCount(BigInteger value);

	boolean validateCpuArchitectureWidth(ArchitectureWidthType value);

	boolean validateCpuCoresInstalled(int value);

	boolean validateCpuDiesInstalled(int value);

	boolean validateCpuManufacturer(String value);

	boolean validateCpuSpeed(long value);

	boolean validateCpuType(String value);

	boolean validateIsVMIDanLPAR(boolean value);

	boolean validateManufacturer(String value);

	boolean validateMemorySize(BigInteger value);

	boolean validateModel(String value);

	boolean validatePrimaryMACAddress(String value);

	boolean validateProcessCapacityUnits(int value);

	boolean validateProcessingCapacity(float value);

	boolean validateProcessingCapacityUnits(ProcessingCapacityUnitsType value);

	boolean validateRomVersion(String value);

	boolean validateSerialNumber(String value);

	boolean validateSignature(String value);

	boolean validateSystemBoardUUID(String value);

	boolean validateSystemId(String value);

	boolean validateType(String value);

	boolean validateVirtual(boolean value);

	boolean validateVmid(String value);
}
