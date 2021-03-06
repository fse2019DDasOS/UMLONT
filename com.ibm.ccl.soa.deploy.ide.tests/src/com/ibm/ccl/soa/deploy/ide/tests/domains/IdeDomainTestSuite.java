/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.domains;

import junit.framework.Test;
import junit.framework.TestSuite;

public class IdeDomainTestSuite extends TestSuite {
	/**
	 * name of suite
	 */
	public IdeDomainTestSuite(String name) {
		super(name);
	}

	/**
	 * defined junits
	 */
	public static Test suite() {
		TestSuite suite = new IdeDomainTestSuite("SOA deploy domain tests");
		suite.addTestSuite(J2eeDomainTest.class);
		suite.addTestSuite(DerbyDomainTest.class);
		suite.addTestSuite(TomcatDomainTest.class);
		suite.addTestSuite(IdeResourceTypeTests.class);
		return suite;
	}
}
