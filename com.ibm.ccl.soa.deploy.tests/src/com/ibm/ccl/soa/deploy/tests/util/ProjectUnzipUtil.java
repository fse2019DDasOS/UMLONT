/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

public class ProjectUnzipUtil {

	private IPath zipLocation;

	private String[] projectNames;

	private IPath rootLocation = ResourcesPlugin.getWorkspace().getRoot()
			.getLocation();

	private static final String META_PROJECT_NAME = ".project";

	public ProjectUnzipUtil(IPath aZipLocation, String[] aProjectNames) {
		zipLocation = aZipLocation;
		projectNames = aProjectNames;

	}

	public boolean createProjects() {
		try {
			expandZip(zipLocation);
			buildProjects();
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	private IProgressMonitor getProgessMonitor() {
		return new NullProgressMonitor();
	}

	public void expandZip(final IPath location) throws CoreException, IOException {
		
		ArrayList<IProject> projects = new ArrayList<IProject>(); 
		ZipFile zipFile = new ZipFile(location.toFile());
		Enumeration entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			String projectName = computeLocation(((ZipEntry) entries.nextElement()).getName()).segment(0);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if( !projects.contains(project) ) {
				projects.add(project);
			}
		}

		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			
			public void run(IProgressMonitor monitor) throws CoreException {
				
				try { 
					ZipFile zipFile = new ZipFile(location.toFile());
					Enumeration entries = zipFile.entries();
					while (entries.hasMoreElements()) {
						ZipEntry entry = (ZipEntry) entries.nextElement();
						File aFile = computeLocation(entry.getName()).toFile();
						File parentFile = null;
						if (entry.isDirectory()) {
							aFile.mkdirs();
						} else {
							parentFile = aFile.getParentFile();
							if (!parentFile.exists())
								parentFile.mkdirs();
							if (!aFile.exists())
								aFile.createNewFile();
							copy(zipFile.getInputStream(entry), new FileOutputStream(aFile));
							if (entry.getTime() > 0)
								aFile.setLastModified(entry.getTime());
						}
					}
				} catch ( IOException ex ) {
					throw new CoreException( new Status(IStatus.ERROR, "com.ibm.ccl.soa.deploy.tests", ex.getMessage(), ex));
				}
			}
			
		}, ResourcesPlugin.getWorkspace().getRoot(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, null);
	}

	private IPath computeLocation(String name) {
		return rootLocation.append(name);
	}

	public static void copy(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024];
		try {
			int n = in.read(buffer);
			while (n > 0) {
				out.write(buffer, 0, n);
				n = in.read(buffer);
			}
		} finally {
			in.close();
			out.close();
		}
	}

	public void setRootLocation(IPath rootLocation) {
		this.rootLocation = rootLocation;
	}

	private void buildProjects() throws CoreException {
		final ArrayList<IProject> projects = new ArrayList<IProject>();
		for( int i = 0; i < projectNames.length; i++ ) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectNames[i]);
			if( !projects.contains(project) ) {
				projects.add(project);
			}
		}
		
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				
			public void run(IProgressMonitor monitor) throws CoreException {
				
				for (Iterator<IProject> iter = projects.iterator(); iter.hasNext(); ) {
					IProject project = iter.next();
					if(!project.exists()) {
						project.create(monitor);
						project.open(monitor);
					}
				}
				
			}
		}, ResourcesPlugin.getWorkspace().getRoot(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor());
	}

}