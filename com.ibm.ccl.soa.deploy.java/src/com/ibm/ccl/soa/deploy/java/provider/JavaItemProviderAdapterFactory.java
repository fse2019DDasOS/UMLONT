/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.ibm.ccl.soa.deploy.java.util.JavaAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class JavaItemProviderAdapterFactory extends JavaAdapterFactory implements
		ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected JavaDeployRootItemProvider javaDeployRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJavaDeployRootAdapter() {
		if (javaDeployRootItemProvider == null) {
			javaDeployRootItemProvider = new JavaDeployRootItemProvider(this);
		}

		return javaDeployRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JdbcProvider} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected JdbcProviderItemProvider jdbcProviderItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JdbcProvider}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJdbcProviderAdapter() {
		if (jdbcProviderItemProvider == null) {
			jdbcProviderItemProvider = new JdbcProviderItemProvider(this);
		}

		return jdbcProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JdbcProviderUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected JdbcProviderUnitItemProvider jdbcProviderUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JdbcProviderUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJdbcProviderUnitAdapter() {
		if (jdbcProviderUnitItemProvider == null) {
			jdbcProviderUnitItemProvider = new JdbcProviderUnitItemProvider(this);
		}

		return jdbcProviderUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JDK} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JDKItemProvider jdkItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JDK}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createJDKAdapter() {
		if (jdkItemProvider == null) {
			jdkItemProvider = new JDKItemProvider(this);
		}

		return jdkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JDKUnit} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JDKUnitItemProvider jdkUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JDKUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJDKUnitAdapter() {
		if (jdkUnitItemProvider == null) {
			jdkUnitItemProvider = new JDKUnitItemProvider(this);
		}

		return jdkUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JRE} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JREItemProvider jreItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JRE}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createJREAdapter() {
		if (jreItemProvider == null) {
			jreItemProvider = new JREItemProvider(this);
		}

		return jreItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JREUnit} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JREUnitItemProvider jreUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JREUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJREUnitAdapter() {
		if (jreUnitItemProvider == null) {
			jreUnitItemProvider = new JREUnitItemProvider(this);
		}

		return jreUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.java.JVMConfig} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JVMConfigItemProvider jvmConfigItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.java.JVMConfig}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createJVMConfigAdapter() {
		if (jvmConfigItemProvider == null) {
			jvmConfigItemProvider = new JVMConfigItemProvider(this);
		}

		return jvmConfigItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (javaDeployRootItemProvider != null) javaDeployRootItemProvider.dispose();
		if (jdbcProviderItemProvider != null) jdbcProviderItemProvider.dispose();
		if (jdbcProviderUnitItemProvider != null) jdbcProviderUnitItemProvider.dispose();
		if (jdkItemProvider != null) jdkItemProvider.dispose();
		if (jdkUnitItemProvider != null) jdkUnitItemProvider.dispose();
		if (jreItemProvider != null) jreItemProvider.dispose();
		if (jreUnitItemProvider != null) jreUnitItemProvider.dispose();
		if (jvmConfigItemProvider != null) jvmConfigItemProvider.dispose();
	}

}
