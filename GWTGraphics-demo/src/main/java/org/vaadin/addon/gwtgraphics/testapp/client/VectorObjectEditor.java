package org.vaadin.addon.gwtgraphics.testapp.client;

import org.vaadin.addon.gwtgraphics.client.DrawingArea;
import org.vaadin.addon.gwtgraphics.client.VectorObject;
import org.vaadin.addon.gwtgraphics.client.VectorObjectContainer;
import org.vaadin.addon.gwtgraphics.testapp.client.components.NullableTextBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class VectorObjectEditor extends FlexTable implements ChangeHandler {

	protected Metadata metadata;

	protected VectorObject vo;

	private ListBox parentList;

	private TextBox rotation;

	private DashEditor dashEditor;

	private boolean newVo;

	public VectorObjectEditor(VectorObject vo, Metadata metadata, boolean newVo) {
		this.vo = vo;
		this.metadata = metadata;
		this.newVo = newVo;

		rotation = addTextBoxRow("Rotation", 8);
		rotation.getElement().setId("rotation");

		parentList = metadata.getParentListBox(vo.getParent());
		parentList.getElement().setId("parent-list");
		addRow("Parent", parentList);

		parentList.addChangeHandler(this);

		if (vo != null) {
			rotation.setText("" + vo.getRotation());
		}

		dashEditor = new DashEditor();
		if(vo!=null){
			dashEditor.setTarget(vo);
		}
		addRow("Dash array", dashEditor);
	}

	protected TextBox addTextBoxRow(String caption, int visibleLength) {
		TextBox box = new NullableTextBox();
		box.setVisibleLength(visibleLength);
		box.addChangeHandler(this);
		addRow(caption, box);
		return box;
	}

	protected void addRow(String caption, Widget widget) {
		int row = getRowCount();
		setHTML(row, 0, caption.equals("") ? "" : caption + ":");
		setWidget(row, 1, widget);
	}

	public void onChange(ChangeEvent event) {
		if (event.getSource() == parentList) {
			int index = parentList.getSelectedIndex();
			if (vo.getParent() != null) {
				vo.setParent((Widget) metadata.getParent(index));
			}
		} else if (event.getSource() == rotation) {
			try {
				vo.setRotation(Integer.parseInt(rotation.getText()));
				getCodeView().addMethodCall(vo, "setRotation",
						rotation.getText());
			} catch (NumberFormatException e) {
			}
			rotation.setText("" + vo.getRotation());
		}
	}

	public VectorObject getVectorObject() {
		return vo;
	}

	public VectorObjectContainer getVectorObjectContainer() {
		return metadata.getParent(parentList.getSelectedIndex());
	}

	public DrawingArea getDrawingArea() {
		return metadata.getDrawingArea();
	}

	protected CodeView getCodeView() {
		return metadata.getCodeView();
	}

	public boolean isNewVectorObject() {
		return newVo;
	}

}
