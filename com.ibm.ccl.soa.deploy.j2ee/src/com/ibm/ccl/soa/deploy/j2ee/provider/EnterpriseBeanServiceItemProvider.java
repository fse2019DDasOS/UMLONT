/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.provider.ServiceItemProvider;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class EnterpriseBeanServiceItemProvider extends ServiceItemProvider implements
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
	public EnterpriseBeanServiceItemProvider(AdapterFactory adapterFactory) {
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

			addEjbNamePropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addVicinityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ejb Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addEjbNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_EnterpriseBeanService_ejbName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_EnterpriseBeanService_ejbName_feature", "_UI_EnterpriseBeanService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__EJB_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Jndi Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addJndiNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_EnterpriseBeanService_jndiName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_EnterpriseBeanService_jndiName_feature", "_UI_EnterpriseBeanService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__JNDI_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Vicinity feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addVicinityPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_EnterpriseBeanService_vicinity_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_EnterpriseBeanService_vicinity_feature", "_UI_EnterpriseBeanService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__VICINITY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE);
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
	 * This returns EnterpriseBeanService.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		//		return overlayImage(object, getResourceLocator().getImage("full/obj16/EnterpriseBeanService")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((EnterpriseBeanService) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_EnterpriseBeanService_type") : //$NON-NLS-1$
				getString("_UI_EnterpriseBeanService_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EnterpriseBeanService.class))
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME:
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME:
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true,
					false));
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

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE, J2eeFactory.eINSTANCE
						.createJavaInterface()));
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

		if (childFeature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE
				|| childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR
				|| childFeature == CorePackage.Literals.SERVICE__INTERFACE
				|| childFeature == J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getCreateChildImage(Object owner, Object feature, Object child,
			Collection selection) {
		if (feature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject) child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			} catch (Exception e) {
				J2eeEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return J2eeEditPlugin.INSTANCE;
	}

}
