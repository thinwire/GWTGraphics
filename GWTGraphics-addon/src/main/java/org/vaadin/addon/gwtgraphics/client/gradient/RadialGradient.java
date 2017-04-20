package org.vaadin.addon.gwtgraphics.client.gradient;

public class RadialGradient extends Gradient {

	private double cx, cy, radius;
	
	RadialGradient() {
		this(0,0,1);
	}
	
	RadialGradient(double cx, double cy, double radius) {
		super("radialGradient");
		setPosition(cx, cy);
		setRadius(radius);
	}
	
	public void setPosition(double cx, double cy) {
		this.cx = cx;
		this.cy = cy;
		setParameter("cx", "" + cx);
		setParameter("cy", "" + cy);
	}
	
	public double getCenterX() {
		return cx;
	}
	
	public double getCenterY() {
		return cy;
	}
	
	public void setRadius(double r) {
		radius = r;
		setParameter("r", "" + r);
	}
	
	public double getRadius() {
		return radius;
	}

}
