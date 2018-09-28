/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisItemProviderAdapterFactory.java,v 1.5 2007/12/10 21:58:01 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.provider;

import com.ibm.ccl.soa.deploy.analysis.util.AnalysisAdapterFactory;

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

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisItemProviderAdapterFactory extends AnalysisAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public AnalysisItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisConstraintItemProvider analysisConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAnalysisConstraintAdapter() {
		if (analysisConstraintItemProvider == null) {
			analysisConstraintItemProvider = new AnalysisConstraintItemProvider(this);
		}

		return analysisConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisDeployRootItemProvider analysisDeployRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAnalysisDeployRootAdapter() {
		if (analysisDeployRootItemProvider == null) {
			analysisDeployRootItemProvider = new AnalysisDeployRootItemProvider(this);
		}

		return analysisDeployRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvailabilityConstraintItemProvider availabilityConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAvailabilityConstraintAdapter() {
		if (availabilityConstraintItemProvider == null) {
			availabilityConstraintItemProvider = new AvailabilityConstraintItemProvider(this);
		}

		return availabilityConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DailyLoadConstraintItemProvider dailyLoadConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDailyLoadConstraintAdapter() {
		if (dailyLoadConstraintItemProvider == null) {
			dailyLoadConstraintItemProvider = new DailyLoadConstraintItemProvider(this);
		}

		return dailyLoadConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataServiceConstraintItemProvider dataServiceConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDataServiceConstraintAdapter() {
		if (dataServiceConstraintItemProvider == null) {
			dataServiceConstraintItemProvider = new DataServiceConstraintItemProvider(this);
		}

		return dataServiceConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.Deployment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentItemProvider deploymentItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.Deployment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDeploymentAdapter() {
		if (deploymentItemProvider == null) {
			deploymentItemProvider = new DeploymentItemProvider(this);
		}

		return deploymentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentUnitItemProvider deploymentUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDeploymentUnitAdapter() {
		if (deploymentUnitItemProvider == null) {
			deploymentUnitItemProvider = new DeploymentUnitItemProvider(this);
		}

		return deploymentUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionServiceConstraintItemProvider executionServiceConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createExecutionServiceConstraintAdapter() {
		if (executionServiceConstraintItemProvider == null) {
			executionServiceConstraintItemProvider = new ExecutionServiceConstraintItemProvider(this);
		}

		return executionServiceConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpectedLifespanConstraintItemProvider expectedLifespanConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createExpectedLifespanConstraintAdapter() {
		if (expectedLifespanConstraintItemProvider == null) {
			expectedLifespanConstraintItemProvider = new ExpectedLifespanConstraintItemProvider(this);
		}

		return expectedLifespanConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpectedVolumeConstraintItemProvider expectedVolumeConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createExpectedVolumeConstraintAdapter() {
		if (expectedVolumeConstraintItemProvider == null) {
			expectedVolumeConstraintItemProvider = new ExpectedVolumeConstraintItemProvider(this);
		}

		return expectedVolumeConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.LocationUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationUnitItemProvider locationUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.LocationUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createLocationUnitAdapter() {
		if (locationUnitItemProvider == null) {
			locationUnitItemProvider = new LocationUnitItemProvider(this);
		}

		return locationUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.Node} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeItemProvider nodeItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		if (nodeItemProvider == null) {
			nodeItemProvider = new NodeItemProvider(this);
		}

		return nodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.NodeUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeUnitItemProvider nodeUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.NodeUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createNodeUnitAdapter() {
		if (nodeUnitItemProvider == null) {
			nodeUnitItemProvider = new NodeUnitItemProvider(this);
		}

		return nodeUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeakLoadConstraintItemProvider peakLoadConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createPeakLoadConstraintAdapter() {
		if (peakLoadConstraintItemProvider == null) {
			peakLoadConstraintItemProvider = new PeakLoadConstraintItemProvider(this);
		}

		return peakLoadConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseTimeConstraintItemProvider responseTimeConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createResponseTimeConstraintAdapter() {
		if (responseTimeConstraintItemProvider == null) {
			responseTimeConstraintItemProvider = new ResponseTimeConstraintItemProvider(this);
		}

		return responseTimeConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SizePerSubmissionConstraintItemProvider sizePerSubmissionConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createSizePerSubmissionConstraintAdapter() {
		if (sizePerSubmissionConstraintItemProvider == null) {
			sizePerSubmissionConstraintItemProvider = new SizePerSubmissionConstraintItemProvider(this);
		}

		return sizePerSubmissionConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageWindowPerDayConstraintItemProvider usageWindowPerDayConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createUsageWindowPerDayConstraintAdapter() {
		if (usageWindowPerDayConstraintItemProvider == null) {
			usageWindowPerDayConstraintItemProvider = new UsageWindowPerDayConstraintItemProvider(this);
		}

		return usageWindowPerDayConstraintItemProvider;
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
		if (analysisConstraintItemProvider != null) analysisConstraintItemProvider.dispose();
		if (analysisDeployRootItemProvider != null) analysisDeployRootItemProvider.dispose();
		if (availabilityConstraintItemProvider != null) availabilityConstraintItemProvider.dispose();
		if (dailyLoadConstraintItemProvider != null) dailyLoadConstraintItemProvider.dispose();
		if (dataServiceConstraintItemProvider != null) dataServiceConstraintItemProvider.dispose();
		if (deploymentItemProvider != null) deploymentItemProvider.dispose();
		if (deploymentUnitItemProvider != null) deploymentUnitItemProvider.dispose();
		if (executionServiceConstraintItemProvider != null) executionServiceConstraintItemProvider.dispose();
		if (expectedLifespanConstraintItemProvider != null) expectedLifespanConstraintItemProvider.dispose();
		if (expectedVolumeConstraintItemProvider != null) expectedVolumeConstraintItemProvider.dispose();
		if (locationUnitItemProvider != null) locationUnitItemProvider.dispose();
		if (nodeItemProvider != null) nodeItemProvider.dispose();
		if (nodeUnitItemProvider != null) nodeUnitItemProvider.dispose();
		if (peakLoadConstraintItemProvider != null) peakLoadConstraintItemProvider.dispose();
		if (responseTimeConstraintItemProvider != null) responseTimeConstraintItemProvider.dispose();
		if (sizePerSubmissionConstraintItemProvider != null) sizePerSubmissionConstraintItemProvider.dispose();
		if (usageWindowPerDayConstraintItemProvider != null) usageWindowPerDayConstraintItemProvider.dispose();
	}

}
