/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmlItemProviderAdapterFactory.java,v 1.10 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.provider;

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

import com.ibm.ccl.soa.deploy.uml.util.UmlAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlItemProviderAdapterFactory extends UmlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLActor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLActorItemProvider umlActorItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLActor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLActorAdapter() {
		if (umlActorItemProvider == null) {
			umlActorItemProvider = new UMLActorItemProvider(this);
		}

		return umlActorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLActorUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLActorUnitItemProvider umlActorUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLActorUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLActorUnitAdapter() {
		if (umlActorUnitItemProvider == null) {
			umlActorUnitItemProvider = new UMLActorUnitItemProvider(this);
		}

		return umlActorUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLComponentItemProvider umlComponentItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLComponentAdapter() {
		if (umlComponentItemProvider == null) {
			umlComponentItemProvider = new UMLComponentItemProvider(this);
		}

		return umlComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLDeployRootItemProvider umlDeployRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLDeployRootAdapter() {
		if (umlDeployRootItemProvider == null) {
			umlDeployRootItemProvider = new UMLDeployRootItemProvider(this);
		}

		return umlDeployRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLElementArtifactItemProvider umlElementArtifactItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLElementArtifactAdapter() {
		if (umlElementArtifactItemProvider == null) {
			umlElementArtifactItemProvider = new UMLElementArtifactItemProvider(this);
		}

		return umlElementArtifactItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLInteractionConstraintItemProvider umlInteractionConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLInteractionConstraintAdapter() {
		if (umlInteractionConstraintItemProvider == null) {
			umlInteractionConstraintItemProvider = new UMLInteractionConstraintItemProvider(this);
		}

		return umlInteractionConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLInterfaceItemProvider umlInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLInterfaceAdapter() {
		if (umlInterfaceItemProvider == null) {
			umlInterfaceItemProvider = new UMLInterfaceItemProvider(this);
		}

		return umlInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLInterfaceUnitItemProvider umlInterfaceUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLInterfaceUnitAdapter() {
		if (umlInterfaceUnitItemProvider == null) {
			umlInterfaceUnitItemProvider = new UMLInterfaceUnitItemProvider(this);
		}

		return umlInterfaceUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLPackageCapItemProvider umlPackageCapItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLPackageCapAdapter() {
		if (umlPackageCapItemProvider == null) {
			umlPackageCapItemProvider = new UMLPackageCapItemProvider(this);
		}

		return umlPackageCapItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.uml.UMLPackageUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLPackageUnitItemProvider umlPackageUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLPackageUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUMLPackageUnitAdapter() {
		if (umlPackageUnitItemProvider == null) {
			umlPackageUnitItemProvider = new UMLPackageUnitItemProvider(this);
		}

		return umlPackageUnitItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (umlActorItemProvider != null) umlActorItemProvider.dispose();
		if (umlActorUnitItemProvider != null) umlActorUnitItemProvider.dispose();
		if (umlComponentItemProvider != null) umlComponentItemProvider.dispose();
		if (umlDeployRootItemProvider != null) umlDeployRootItemProvider.dispose();
		if (umlElementArtifactItemProvider != null) umlElementArtifactItemProvider.dispose();
		if (umlInteractionConstraintItemProvider != null) umlInteractionConstraintItemProvider.dispose();
		if (umlInterfaceItemProvider != null) umlInterfaceItemProvider.dispose();
		if (umlInterfaceUnitItemProvider != null) umlInterfaceUnitItemProvider.dispose();
		if (umlPackageCapItemProvider != null) umlPackageCapItemProvider.dispose();
		if (umlPackageUnitItemProvider != null) umlPackageUnitItemProvider.dispose();
	}

}
