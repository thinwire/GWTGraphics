package org.vaadin.addon.gwtgraphics.client.transform;

public class RotationTransform extends Transform {

	public RotationTransform(double angle) {
		super(TransformType.ROTATE, angle);
	}
	
	public void setAngle(double angle) {
		setValue(0,angle);
	}
	
	public double getAngle() {
		return getValue(0);
	}
	
}
