package com.ibm.ccl.soa.deploy.analysis.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.analysis.ui.figures.AnalysisFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;

public class NodeUnitEditPart extends UnitGroupEditPart  {
	public NodeUnitEditPart(View view) {
		super(view);
		setCategory(AnalysisUIMessages.NodeUnitEditPart_Nod_);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = AnalysisFigureFactory.createNewNodeUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}