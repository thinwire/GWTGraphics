package org.vaadin.addon.gwtgraphics.client.transform;

public class MatrixTransform extends Transform {

	public MatrixTransform(double a, double b, double c, double d, double tx, double ty) {
		super(TransformType.MATRIX, a, b, c, d, tx, ty);
	}
	
	public void set(double a, double b, double c, double d, double tx, double ty) {
		setValues(a,b,c,d,tx,ty);
	}
	
	public double getA() {
		return getValue(0);
	}
	
	public double getB() {
		return getValue(1);
	}

	public double getC() {
		return getValue(2);
	}

	public double getD() {
		return getValue(3);
	}

	public double getTX() {
		return getValue(4);
	}

	public double getTY() {
		return getValue(5);
	}
	
}
