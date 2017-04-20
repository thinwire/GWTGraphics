package org.vaadin.addon.gwtgraphics.client.transform;

public class SkewTransform extends Transform {

	public SkewTransform(double value, boolean horizontal) {
		super(horizontal ? TransformType.SKEW_X : TransformType.SKEW_Y, value);
	}
	
	public void setHorizontal() {
		setType(TransformType.SKEW_X);
	}
	
	public void setVertical() {
		setType(TransformType.SKEW_Y);
	}
	
	public boolean isHorizontal() {
		TransformType t = getType();
		return t == TransformType.SKEW_X;
	}
	
	public boolean isVertical() {
		TransformType t = getType();
		return t == TransformType.SKEW_Y;
	}

	public void set(double value) {
		setValue(0, value);
	}
	
	public double getValue() {
		return getValue(0);
	}
	
}
