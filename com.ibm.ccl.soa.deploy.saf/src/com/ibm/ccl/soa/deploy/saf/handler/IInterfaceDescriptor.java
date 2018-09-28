/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.handler;

/**
 * Provides a lightweight descriptor that can be used to render in UIs without forcing plugins to
 * load.
 * 
 */
public interface IInterfaceDescriptor extends ICommonDescriptor {

	/**
	 * Return an instance of the {@link AbstractInterfaceHandler} defined by the extension or null if
	 * a problem occurs.
	 * 
	 * @return An instance of the {@link AbstractInterfaceHandler} defined by the extension or null
	 *         if a problem occurs.
	 */
	AbstractInterfaceHandler createInterfaceHandler();
}
