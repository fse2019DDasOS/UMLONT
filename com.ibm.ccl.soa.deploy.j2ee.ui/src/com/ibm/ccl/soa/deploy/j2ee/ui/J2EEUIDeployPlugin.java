/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.j2ee.ui.handlers.util.TypeFilter;

/**
 * The main plugin class to be used in the desktop.
 */
public class J2EEUIDeployPlugin extends AbstractUIPlugin {
	/**
	 * The unique identifier for the RadUI plugin.
	 */
	public static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.j2ee.ui"; //$NON-NLS-1$

	//The shared instance.
	private static J2EEUIDeployPlugin instance;

	/**
	 * The constructor.
	 */
	public J2EEUIDeployPlugin() {
		instance = this;
	}

	/**
	 * Default instance of the appearance type filters.
	 * 
	 * @since 3.0
	 */
	private TypeFilter fTypeFilter;

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		instance = null;

		if (fTypeFilter != null) {
			fTypeFilter.dispose();
			fTypeFilter = null;
		}
	}

	/**
	 * Returns the shared instance.
	 */
	public static J2EEUIDeployPlugin getDefault() {
		return instance;
	}

	public synchronized TypeFilter getTypeFilter() {
		if (fTypeFilter == null)
			fTypeFilter = new TypeFilter();
		return fTypeFilter;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path
	 *           the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void logError(int aCode, String aMessage, Throwable anException) {
		getDefault().getLog().log(createErrorStatus(aCode, aMessage, anException));
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void log(int severity, int aCode, String aMessage, Throwable anException) {
		log(createStatus(severity, aCode, aMessage, anException));
	}

	/**
	 * Publish the status to the log.
	 * 
	 * @param aStatus
	 *           The status to publish to the log.
	 */
	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	/**
	 * Create a status using the DeployCorePlugin's id.
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage,
			Throwable anException) {
		return new Status(severity, PLUGIN_ID, aCode, aMessage, anException);
	}

	/**
	 * Create a status with the severity set to {@link IStatus#ERROR}.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable anException) {
		return createStatus(IStatus.ERROR, aCode, aMessage, anException);
	}
}