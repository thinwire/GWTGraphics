package org.vaadin.addon.gwtgraphics.testapp.client;

import org.vaadin.addon.gwtgraphics.client.Shape;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.TextBox;

public class ShapeEditor extends VectorObjectEditor{

	private TextBox xCoord;

	private TextBox yCoord;

	private TextBox fillColor;

	private TextBox fillOpacity;

	private TextBox strokeColor;

	private TextBox strokeWidth;

	private TextBox strokeOpacity;

	protected AnimatableEditor animatableEditor;

	private GradientEditor gradientEditor;

	public ShapeEditor(Shape vo, Metadata metadata, boolean newVo) {
		super(vo, metadata, newVo);
		xCoord = addTextBoxRow("X", 3);
		yCoord = addTextBoxRow("Y", 3);
		fillColor = addTextBoxRow("Fill color", 8);
		fillOpacity = addTextBoxRow("Fill opacity", 8);
		strokeColor = addTextBoxRow("Stroke color", 8);
		strokeWidth = addTextBoxRow("Stroke width", 8);
		strokeOpacity = addTextBoxRow("Stroke opacity", 8);

		// TODO: add support for stipple, gradient, etc.

		animatableEditor = new AnimatableEditor(metadata);
		animatableEditor.addProperties(new String[] { "x", "y", "fillopacity",
				"strokeopacity", "strokewidth", "rotation" });

		addRow("Animation", animatableEditor);

		gradientEditor = new GradientEditor();
		gradientEditor.addProperties(new String[]{GradientEditor.LINEAR_GRADIENT, GradientEditor.RADIAL_GRADIENT});
		gradientEditor.setTarget(vo);
		addRow("Gradient", gradientEditor);


		if (vo != null) {
			xCoord.setText("" + vo.getX());
			yCoord.setText("" + vo.getY());
			if(vo.getFill() != null) {
				fillColor.setText(vo.getFill().getStyle());
				fillOpacity.setText("" + vo.getFill().getOpacity());
			}
			strokeColor.setText(vo.getStroke().getColor());
			strokeWidth.setText("" + vo.getStroke().getLineWidth());
			strokeOpacity.setText("" + vo.getStroke().getOpacity());

		}
	}

	@Override
	public void onChange(ChangeEvent event) {
		Object sender = event.getSource();
		super.onChange(event);
		if (vo == null) {
			return;
		}

		Shape shape = (Shape) vo;
		CodeView code = getCodeView();
		if (sender == xCoord) {
			try {
				shape.setPosition(Integer.parseInt(xCoord.getText()), shape.getY());
				metadata.getCodeView().addMethodCall(vo, "setX", shape.getX());
			} catch (NumberFormatException e) {
			}
			xCoord.setText("" + shape.getX());
		} else if (sender == yCoord) {
			try {
				shape.setPosition(shape.getX(), Integer.parseInt(yCoord.getText()));
				metadata.getCodeView().addMethodCall(vo, "setY", shape.getY());
			} catch (NumberFormatException e) {
			}
			yCoord.setText("" + shape.getY());

		} else if (sender == fillColor && shape.getFill()!=null) {
			shape.getFill().setStyle(fillColor.getText());
			code.addMethodCall(vo, "setFillColor", shape.getFill().getStyle());
			fillColor.setText(shape.getFill().getStyle());
		} else if (sender == fillOpacity && shape.getFill()!=null) {
			try {
				shape.getFill().setOpacity(Double.parseDouble(fillOpacity.getText()));
				code.addMethodCall(vo, "setFillOpacity", shape.getFill().getOpacity());
			} catch (NumberFormatException e) {
			}
			fillOpacity.setText("" + shape.getFill().getOpacity());
		} else if (sender == strokeColor) {
			shape.getStroke().setColor(strokeColor.getText());
			code.addMethodCall(vo, "setStrokeColor", shape.getStroke().getColor());
			strokeColor.setText(shape.getStroke().getColor());
		} else if (sender == strokeWidth) {
			try {
				shape.getStroke().setLineWidth(Integer.parseInt(strokeWidth.getText()));
				code.addMethodCall(vo, "setStrokeWidth", shape.getStroke().getLineWidth());
			} catch (NumberFormatException e) {
			}
			strokeWidth.setText("" + shape.getStroke().getLineWidth());
		} else if (sender == strokeOpacity) {
			try {
				shape.getStroke().setOpacity(Double.parseDouble(strokeOpacity
						.getText()));
				code.addMethodCall(vo, "setStrokeOpacity",
						shape.getStroke().getOpacity());
			} catch (NumberFormatException e) {
			}
			strokeOpacity.setText("" + shape.getStroke().getOpacity());
		}

	}
}
