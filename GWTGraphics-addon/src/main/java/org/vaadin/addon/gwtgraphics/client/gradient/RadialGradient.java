package org.vaadin.addon.gwtgraphics.client.gradient;

import org.vaadin.addon.gwtgraphics.client.impl.util.SVGUtil;

import com.google.gwt.dom.client.Element;

public class RadialGradient extends Gradient {

	protected double cx, cy, fx, fy, radius;

	public RadialGradient() {
	}

	/**
	 *
	 * @param cx
	 *            A value between 0.0 and 1.0
	 * @param cy
	 *            A value between 0.0 and 1.0
	 * @param fx
	 *            A value between 0.0 and 1.0
	 * @param fy
	 *            A value between 0.0 and 1.0
	 * @param radius
	 */
	public RadialGradient(double cx, double cy,  double fx, double fy, double radius) {
		this.cx = cx;
		this.cy = cy;
		this.fx = fx;
		this.fy = fy;
		setRadius(radius);
	}



	public void setRadius(double r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public double getCx() {
		return cx;
	}

	/**
	 *
	 * @param cx
	 *            A value between 0.0 and 1.0
	 */
	public void setCx(double cx) {
		this.cx = cx;
	}

	public double getCy() {
		return cy;
	}

	/**
	 *
	 * @param cy
	 *            A value between 0.0 and 1.0
	 */
	public void setCy(double cy) {
		this.cy = cy;
	}

	public double getFx() {
		return fx;
	}

	/**
	 *
	 * @param fx
	 *            A value between 0.0 and 1.0
	 */
	public void setFx(double fx) {
		this.fx = fx;
	}

	public double getFy() {
		return fy;
	}

	/**
	 *
	 * @param fy
	 *            A value between 0.0 and 1.0
	 */
	public void setFy(double fy) {
		this.fy = fy;
	}

	@Override
	public Element getElement() {
		Element element = SVGUtil.createSVGElementNS("radialGradient");
		element.setAttribute("radius", ""+radius);
		element.setAttribute("cx", ""+cx);
		element.setAttribute("cy", ""+cy);
		element.setAttribute("fx", ""+fx);
		element.setAttribute("fy", ""+fy);
		element.setAttribute("id", getId());
		for (GradientStop stop: getStops()) {
			element.appendChild(stop.getElement());
		}
		return element;
	}

}
