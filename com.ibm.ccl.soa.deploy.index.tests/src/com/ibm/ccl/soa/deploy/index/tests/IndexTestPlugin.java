package com.ibm.ccl.soa.deploy.index.tests;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class IndexTestPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ibm.ccl.soa.deploy.index.tests";

	// The shared instance
	private static IndexTestPlugin plugin;
	
	/**
	 * The constructor
	 */
	public IndexTestPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static IndexTestPlugin getDefault() {
		return plugin;
	}

}
