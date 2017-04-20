package org.vaadin.addon.gwtgraphics.client.gradient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GradientTransform {

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
	
	private GradientTransform(TransformType type, double... values) {
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
	
	public static GradientTransform rotation(double amount) {
		return new GradientTransform(TransformType.ROTATE, amount); 
	}
	
	public static GradientTransform translation(double xamount, double yamount) {
		return new GradientTransform(TransformType.TRANSLATE, xamount, yamount);
	}
	
	public static GradientTransform scaling(double amount) {
		return new GradientTransform(TransformType.SCALE, amount);
	}
	
	public static GradientTransform scaling(double xamount, double yamount) {
		return new GradientTransform(TransformType.SCALE, xamount, yamount);
	}
	
	public static GradientTransform skewX(double amount) {
		return new GradientTransform(TransformType.SKEW_X, amount);
	}
	
	public static GradientTransform skewY(double amount) {
		return new GradientTransform(TransformType.SKEW_Y, amount);
	}
	
	public static GradientTransform matrix(double a, double b, double c, double d, double tx, double ty) {
		return new GradientTransform(TransformType.MATRIX, a, b, c, d, tx, ty);
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
