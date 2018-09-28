/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.location;

import junit.framework.Test;
import junit.framework.TestSuite;

public class LocationTestSuite extends TestSuite {

	public LocationTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite = new LocationTestSuite("Location Binding Tests");
		suite.addTestSuite(CreateLocationBindingTest.class);
		suite.addTestSuite(LocationBindingUsageTests.class);
		return suite;
	}
}
