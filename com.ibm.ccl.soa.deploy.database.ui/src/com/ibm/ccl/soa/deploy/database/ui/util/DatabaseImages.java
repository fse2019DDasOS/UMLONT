/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui.util;

import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.database.ui.DatabaseUIPlugin;

public class DatabaseImages {
	// images
	public static final Image Database_UNIT__IMAGE = createImage("icons/images/application_srv_dgm.gif"); //$NON-NLS-1$

	private static Image createImage(String path) {
		return DatabaseUIPlugin.getImageDescriptor(path).createImage();
	}
}
