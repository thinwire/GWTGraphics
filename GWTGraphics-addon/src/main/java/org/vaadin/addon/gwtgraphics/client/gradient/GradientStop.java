package org.vaadin.addon.gwtgraphics.client.gradient;

import org.vaadin.addon.gwtgraphics.client.impl.util.SVGUtil;

import com.google.gwt.dom.client.Element;

public class GradientStop{

	protected double offset = 0;
	protected double opacity = 1.0;
	protected String color = "";
	protected String className = "";

	public GradientStop() {
		this(0, 1.0, "white");
	}

	/**
	 *
	 * @param offsetPct
	 *            The offset given as a value between 0.0 and 1.0
	 * @param opacity
	 *            The opacity given as a value between 0.0 and 1.0
	 * @param color
	 */
	public GradientStop(double offsetPct, double opacity, String color) {
		offset = offsetPct;
		this.opacity = opacity;
		this.color = color;
	}

	/**
	 * @param pct
	 *            The offset given as a value between 0.0 and 1.0
	 */
	public void setOffset(double pct) {
		offset = Math.min(1.0, Math.max(0, pct));
	}

	public double getOffset() {
		return offset;
	}

	public void setColor(String color) {
		if(color == null) {
			color = "";
		}
		this.color = color;
	}

	/**
	 *
	 * @param opacity
	 *            The opacity given as a value between 0.0 and 1.0
	 */
	public void setOpacity(double opacity) {
		this.opacity = offset = Math.min(1, Math.max(0, opacity));
	}

	public double getOpacity() {
		return opacity;
	}

	public void setClassName(String cls) {
		if(cls == null) {
			cls = "";
		}
		className = cls;
	}

	public String getClassName() {
		return className;
	}

	public String getColor() {
		return color;
	}


	public Element getElement() {
		Element se = SVGUtil.createSVGElementNS("stop");
		se.setAttribute("offset", "" + getOffset());
		se.setAttribute("stop-color", getColor());
		se.setAttribute("stop-opacity", "" + getOpacity());
		return se;
	}

}