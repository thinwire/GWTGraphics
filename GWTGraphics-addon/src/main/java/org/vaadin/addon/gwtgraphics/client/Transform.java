package org.vaadin.addon.gwtgraphics.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transform {

	public enum TransformType {
		ROTATE,
		TRANSLATE,
		SCALE,
		SKEW_X,
		SKEW_Y,
		MATRIX
	}
	
	private TransformType type;
	private List<Double> values = new ArrayList<Double>();
	
	private Transform(TransformType type, double... values) {
		this.type = type;
		for(double v : values) {
			this.values.add(v);
		}
	}
	
	public TransformType getType() {
		return type;
	}
	
	public String getTypeString() {
		switch(type) {
		case MATRIX:
			return "matrix";
		case ROTATE:
			return "rotate";
		case SCALE:
			return "scale";
		case SKEW_X:
			return "skewX";
		case SKEW_Y:
			return "skewY";
		case TRANSLATE:
			return "translate";
		}
		return "rotate";
	}
	
	public static Transform rotation(double amount) {
		return new Transform(TransformType.ROTATE, amount); 
	}
	
	public static Transform translation(double xamount, double yamount) {
		return new Transform(TransformType.TRANSLATE, xamount, yamount);
	}
	
	public static Transform scaling(double amount) {
		return new Transform(TransformType.SCALE, amount);
	}
	
	public static Transform scaling(double xamount, double yamount) {
		return new Transform(TransformType.SCALE, xamount, yamount);
	}
	
	public static Transform skewX(double amount) {
		return new Transform(TransformType.SKEW_X, amount);
	}
	
	public static Transform skewY(double amount) {
		return new Transform(TransformType.SKEW_Y, amount);
	}
	
	public static Transform matrix(double a, double b, double c, double d, double tx, double ty) {
		return new Transform(TransformType.MATRIX, a, b, c, d, tx, ty);
	}
	
	/**
	 * Generate an SVG string.
	 * @return tag field declaration, for example "transform=\"rotate(45)\""
	 */
	public String toSVGString() {
		String tag = "transform=\"";
		tag += getTypeString();
		tag += "(";
		Iterator<Double> it = values.iterator();
		while(it.hasNext()) {
			double value = it.next();
			tag += value;
			if(it.hasNext()) {
				tag += ",";
			}
		}
		tag += ")\"";
		return tag;
	}
	
}
