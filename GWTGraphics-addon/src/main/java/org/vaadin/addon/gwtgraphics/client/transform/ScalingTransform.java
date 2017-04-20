package org.vaadin.addon.gwtgraphics.client.transform;

public class ScalingTransform extends Transform {

	public ScalingTransform(double scale) {
		super(TransformType.SCALE, scale, scale);
	}
	
	public ScalingTransform(double scaleX, double scaleY) {
		super(TransformType.SCALE, scaleX, scaleY);
	}
	
	public void set(double scale) {
		setValue(0,scale);
	}
	
	public void set(double scaleX, double scaleY) {
		setValue(0,scaleX);
		setValue(1,scaleY);
	}
	
	public double getScaleX() {
		return getValue(0);
	}
	
	public double getScaleY() {
		return getValue(1);
	}
	
}
