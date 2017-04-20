package org.vaadin.addon.gwtgraphics.client.stroke;

import java.util.ArrayList;
import java.util.List;

public class Stroke {

	public static enum LineCap {
		BUTT,
		SQUARE,
		ROUND
	}
	
	public static enum LineJoin {
		MITER,
		ROUND,
		BEVEL
	}
	
	private List<Double> dashArray = null;
	private LineCap lineCap = null;
	private LineJoin lineJoin = null;
	private String color;
	private double width = 1.0;
	private double miterLimit = 4.0;
	private double dashOffset = 0.0;
	private double opacity = 1.0;
	
	public Stroke() {
		this("black");
	}
	
	public Stroke(String color) {
		this.color = color == null ? "" : color;
	}
	
	public void setDashArray(double... values) {
		if(dashArray != null) {
			dashArray = new ArrayList<Double>();
		}
		dashArray.clear();
		for(double d : values) {
			dashArray.add(d);
		}
	}
	
	/**
	 * Returns a temporary array with the defined dash array values
	 * 
	 * @return
	 */
	public double[] getDashArray() {
		if(dashArray == null) {
			return new double[0];
		}
		double[] values = new double[dashArray.size()];
		int i = 0;
		for(double d : dashArray) {
			values[i++] = d;
		}
		return values;
	}
	
	public void setDashOffset(double offs) {
		dashOffset = offs;
	}
	
	public double getDashOffset() {
		return dashOffset;
	}
	
	public void setColor(String color) {
		color = color == null ? "none" : color;
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	 * Returns properties formatted for inclusion in an SVG tag
	 * 
	 * @return a string representing a number of SVG properties
	 */
	public String toSVGString() {
		
		
		return "";
	}
	
}
