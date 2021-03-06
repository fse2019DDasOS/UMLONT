package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.CreateNamespaceChangeOperation;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateNamespaceChange;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class CreateNamespaceChangeProvider extends DeployRefactoringChangeProvider implements
		ICreateNamespaceChangeProperties {

	/*
	 * Hold an instance to our type safe data model.
	 */
	private CreateNamespaceChange namespaceDataModel;

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateNamespaceChangeProperties#SOURCE_PATH
	 * 
	 */
	public IStatus validateSourcePath() {
		String sourcePathProperty = model
				.getStringProperty(ICreateNamespaceChangeProperties.SOURCE_PATH);
		sourcePathProperty = sourcePathProperty.trim();
		if (sourcePathProperty == null || sourcePathProperty.length() < 1) {
			return DeployCorePlugin.createErrorStatus(0,
					DeployCoreMessages.CreateTopologyDataModelProvider_The_source_folder_is_required_,
					null);
		}
		// Validate that the first segment resolves to a project.
		IPath sourcePath = new Path(sourcePathProperty);
		try {
			String projectName = sourcePath.segment(0);
			IProject project = projectName != null ? ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName) : null;

			if (project == null || !project.exists()) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								NLS
										.bind(
												DeployCoreMessages.CreateTopologyDataModelProvider_The_selected_souce_folder_project_,
												projectName), null);
			} else if (!project.isAccessible()) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								NLS
										.bind(
												DeployCoreMessages.CreateTopologyDataModelProvider_The_selected_souce_folder_project__2,
												projectName), null);
			}/*
			 * else if(sourcePath.segmentCount() == 1){//Make it so that project cannot be source
			 * folder return DeployCorePlugin .createErrorStatus( 0, NLS .bind(
			 * DeployCoreMessages.CreateTopologyDataModelProvider_Projects_cannot_be_used_as_source_f_,
			 * projectName), null); }
			 */
			// This is a temporary restriction.
			if (sourcePath.segmentCount() > 2) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								DeployCoreMessages.CreateTopologyDataModelProvider_The_source_folder_is_limitted_to_a_,
								null);
			}
			if (sourcePath.segmentCount() > 1) {
				IContainer sourceContainer = getSourceContainer();
				// Validate that it exists.
				if (sourceContainer == null || !sourceContainer.exists()) {
					// Validate that the segment doesn't contain invalid
					// characters.
					String segment = sourcePath.segment(1);
					IStatus status = ResourcesPlugin.getWorkspace().validateName(segment,
							IResource.FOLDER);
					if (!status.isOK()) {
						return status;
					}
					return DeployCorePlugin
							.createStatus(
									IStatus.WARNING,
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_topology_source_path_0_does_,
									null);
				}
				if (!sourceContainer.isAccessible()) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_The_container_for_the_path_0_do_,
													sourcePath.toString()), null);
				}
				// Validate that the selected container is not already a
				// namespace.
				INamespaceElement element = NamespaceCore.create(sourceContainer);
				if (element != null && element.getType() == INamespaceElement.TOPOLOGY_NAMESPACE) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_The_source_path_0_resolves_to_a_,
													sourcePath.toString()), null);
				}
			} else {
				return DeployCorePlugin
						.createStatus(
								IStatus.ERROR,
								0,
								DeployCoreMessages.CreateTopologyDataModelProvider_Projects_cannot_be_used_as_source_f_,
								null);
			}
		} catch (Exception e) {
			// This will happen if we have an invalid format.
			return DeployCorePlugin.createErrorStatus(0, NLS.bind(
					DeployCoreMessages.CreateTopologyDataModelProvider_The_source_path_0_is_not_a_vali_,
					sourcePath.toString()), e);
		}
		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the SourcePath property.
	 * @see ICreateNamespaceChangeProperties#SOURCE_PATH
	 * @see CreateNamespaceDataModel#getSourcePath()
	 * 
	 */
	protected String getDefaultSourcePath() {
		return ""; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateNamespaceChangeProperties#NAMESPACE_PATH
	 * 
	 */
	public IStatus validateNamespacePath() {
		if (model.isPropertySet(ICreateNamespaceChangeProperties.NAMESPACE_PATH)) {
			String namespacePath = model
					.getStringProperty(ICreateNamespaceChangeProperties.NAMESPACE_PATH);
			return validateNamespace(namespacePath);
		}
		return Status.OK_STATUS;
	}

	/*
	 * The namespace cannot contain any slashes.
	 */
	private IStatus validateNamespace(String namespace) {
		if (namespace != null) {
			String name = namespace.trim();
			if (name.length() > 0) {
				int length = name.length();
				if (name.charAt(0) == IConstants.DOT_SEPARATOR
						|| name.charAt(length - 1) == IConstants.DOT_SEPARATOR) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_must_not_start_or_end_,
									null);
				}
				int dot = 0;
				while (dot != -1 && dot < length - 1) {
					if ((dot = name.indexOf(IConstants.DOT_SEPARATOR, dot + 1)) != -1
							&& dot < length - 1 && name.charAt(dot + 1) == IConstants.DOT_SEPARATOR) {
						return DeployCorePlugin
								.createErrorStatus(
										0,
										DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_cannot_contain_consec_,
										null);
					}
				}
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				StringTokenizer st = new StringTokenizer(name, String.valueOf(IConstants.DOT_SEPARATOR));
				boolean firstToken = true;
				IStatus warningStatus = null;
				while (st.hasMoreTokens()) {
					String typeName = st.nextToken();
					typeName = typeName.trim(); // grammar allows spaces
					char[] typeNameChars = typeName.toCharArray();
					for (int i = 0; i < typeNameChars.length; i++) {
						char c = typeNameChars[i];
						if (Character.isWhitespace(c)) {
							return DeployCorePlugin
									.createErrorStatus(
											0,
											DeployCoreMessages.CreateTopologyDataModelProvider_Spaces_are_not_valid_characters_in_,
											null);
						}
						if (c == '/' || c == '\\' || !Character.isLetterOrDigit(c)) {
							return DeployCorePlugin
									.createErrorStatus(
											0,
											NLS
													.bind(
															DeployCoreMessages.CreateTopologyDataModelProvider_0_is_an_invalid_character_in_the_,
															new Object[] { new Character(c), typeName }), null);
						}
					}
					IStatus status = workspace.validateName(typeName, IResource.FOLDER);
					if (!status.isOK()) {
						return status;
					}
					if (firstToken && typeNameChars.length > 0
							&& Character.isUpperCase(typeNameChars[0])) {
						if (warningStatus == null) {
							warningStatus = DeployCorePlugin
									.createStatus(
											IStatus.WARNING,
											0,
											DeployCoreMessages.CreateTopologyDataModelProvider_By_convention_namespaces_typically_,
											null);
						}
					}
					firstToken = false;
				}
				IContainer container = getNamespaceChange().getNamespaceContainer();
				if (container == null || !container.exists()) {
					warningStatus = DeployCorePlugin
							.createStatus(
									IStatus.WARNING,
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_doesn_t_exist_and_wil_,
									null);
				}

				if (container != null && container.exists()) {
					INamespaceFragment fragment = NamespaceCore.findNamespace(container.getProject(),
							namespace);
					if (fragment != null && fragment.exists()) {
						if (warningStatus == null) {
							warningStatus = DeployCorePlugin
									.createStatus(
											IStatus.ERROR,
											0,
											DeployCoreMessages.CreateNamespaceDataModelProvider_A_namspace_with_the_specified_name_,
											null);
						}
					}
				}
				if (warningStatus != null) {
					return warningStatus;
				}
			}
		}
		return OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the NamespacePath property.
	 * @see ICreateNamespaceChangeProperties#NAMESPACE_PATH
	 * @see CreateNamespaceDataModel#getNamespacePath()
	 * 
	 */
	protected String getDefaultNamespacePath() {
		return ""; //$NON-NLS-1$ 
	}

	private IContainer getNamespaceContainer() {
		CreateNamespaceChange myDataModel = getNamespaceChange();
		return computeContainerFromNamespace(getSourceContainer(), myDataModel.getNamespacePath());
	}

	/**
	 * 
	 * @param root
	 * @param namespace
	 * @return
	 */
	public static IContainer computeContainerFromNamespace(IContainer root, String namespace) {
		IContainer namespaceContainer = root;
		if (namespace != null && root != null && namespace.length() > 0) {
			IPath namespacePath = new Path(namespace.replace('.', '/'));
			namespaceContainer = root.getFolder(namespacePath);
		}
		return namespaceContainer;
	}

	private IContainer getSourceContainer() {
		CreateNamespaceChange myDataModel = getNamespaceChange();
		String sourcePath = myDataModel.getSourcePath();
		if (sourcePath != null && sourcePath.length() > 0) {
			return getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	/**
	 * 
	 * @param workspaceRelativePath -
	 *           An {@link IPath} that is workspace relative (i.e., the first segment is a project
	 *           name.
	 * @return An {@link IContainer} resolved from the workspaceRelativePath.
	 */
	public static IContainer getWorkspaceRelativeContainer(IPath workspaceRelativePath) {
		IContainer container = null;
		if (workspaceRelativePath != null && workspaceRelativePath.segmentCount() > 0) {
			// The project is the first segment in the path.
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
					workspaceRelativePath.segment(0));
			if (workspaceRelativePath.segmentCount() > 1) {
				IPath projectRelativePath = null;
				// Remove the project segment and set the folder within the
				// project.
				if (project != null && project.isAccessible()) {
					projectRelativePath = workspaceRelativePath.removeFirstSegments(1);
					container = project.getFolder(projectRelativePath);
				}
			} else {
				// The project is the source container.
				container = project;
			}
		}
		return container;
	}

	private CreateNamespaceChange getNamespaceChange() {
		if (namespaceDataModel == null) {
			namespaceDataModel = new CreateNamespaceChange(getDataModel());
		}
		return namespaceDataModel;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (ICreateNamespaceChangeProperties.SOURCE_PATH.equals(property)) {
			return validateSourcePath();
		} else if (ICreateNamespaceChangeProperties.NAMESPACE_PATH.equals(property)) {
			return validateNamespacePath();
		} else {
			return Status.OK_STATUS;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (ICreateNamespaceChangeProperties.SOURCE_PATH.equals(property)) {
			return getDefaultSourcePath();
		} else if (ICreateNamespaceChangeProperties.NAMESPACE_PATH.equals(property)) {
			return getDefaultNamespacePath();
		} else {
			return null;
		}

	}

	/**
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		return super.propertySet(propertyName, propertyValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(ICreateNamespaceChangeProperties.SOURCE_PATH);
		propertyNames.add(ICreateNamespaceChangeProperties.NAMESPACE_PATH);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new CreateNamespaceChangeOperation(model);
	}

}
