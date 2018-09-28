/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Instantiation;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.Instantiation} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class InstantiationItemProvider extends DeployModelObjectItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public InstantiationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addReferencedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Referenced feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addReferencedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Instantiation_referenced_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Instantiation_referenced_feature", "_UI_Instantiation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.INSTANTIATION__REFERENCED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
	 * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP);
			childrenFeatures.add(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP);
			childrenFeatures.add(CorePackage.Literals.INSTANTIATION__CONFIGURED_PROPERTIES);
			childrenFeatures.add(CorePackage.Literals.INSTANTIATION__AUGMENTATION_GROUP);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Instantiation.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Instantiation")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Instantiation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Instantiation_type") : //$NON-NLS-1$
			getString("_UI_Instantiation_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Instantiation.class)) {
			case CorePackage.INSTANTIATION__REFERENCED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES,
					 CoreFactory.eINSTANCE.createCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES,
					 CoreFactory.eINSTANCE.createBundleCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES,
					 CoreFactory.eINSTANCE.createCommunicationCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES,
					 CoreFactory.eINSTANCE.createService())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE,
					 CoreFactory.eINSTANCE.createBundleCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION,
					 CoreFactory.eINSTANCE.createCommunicationCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE,
					 CoreFactory.eINSTANCE.createService())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS,
					 CoreFactory.eINSTANCE.createRequirement())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS,
					 CoreFactory.eINSTANCE.createReference())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE,
					 CoreFactory.eINSTANCE.createReference())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__CONFIGURED_PROPERTIES,
				 CoreFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.INSTANTIATION__AUGMENTATION_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.INSTANTIATION__AUGMENTATIONS,
					 CoreFactory.eINSTANCE.createAugmentation())));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR ||
			childFeature == CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE ||
			childFeature == CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return DeployCoreEditPlugin.INSTANCE;
	}

}
