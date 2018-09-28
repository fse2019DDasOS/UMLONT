/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.validation;

import com.ibm.ccl.soa.deploy.java.ClassAccessMode;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.java.JVMConfig}. This doesn't
 * really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JVMConfigValidator {
	boolean validate();

	boolean validateBootClasspath(String value);

	boolean validateClasspath(String value);

	boolean validateDebugArgs(String value);

	boolean validateDisableJIT(boolean value);

	boolean validateExecutableJarfileName(String value);

	boolean validateGenericJvmArguments(String value);

	boolean validateInitialHeapSize(int value);

	boolean validateInternalClassAccessMode(ClassAccessMode value);

	boolean validateMaximumHeapSize(int value);

	boolean validateRunHProf(String value);

	boolean validateVerboseModeClass(boolean value);

	boolean validateVerboseModeGarbageCollection(boolean value);

	boolean validateVerboseModeJNI(boolean value);
}
