package org.vaadin.addon.gwtgraphics.client.gradient;

public class LinearGradient extends Gradient {

	private double x0, y0, x1, y1;
	
	LinearGradient() {
		this(0,0,1,1);
	}
	
	LinearGradient(double x0, double y0, double x1, double y1) {
		super("linearGradient");
		setStartPosition(x0, y0);
		setEndPosition(x1, y1);
	}
	
	public void setStartPosition(double x, double y) {
		x0 = x;
		y0 = y;
		setParameter("x0", "" + x);
		setParameter("y0", "" + y);
	}
	
	public double getStartX() {
		return x0;
	}
	
	public double getStartY() {
		return y0;
	}
	
	public void setEndPosition(double x, double y) {
		x1 = x;
		y1 = y;
		setParameter("x1", "" + x);
		setParameter("y1", "" + y);
	}
	
	public double getEndX() {
		return x1;
	}
	
	public double getEndY() {
		return y1;
	}
	
}
