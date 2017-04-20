package org.vaadin.addon.gwtgraphics.client.gradient;

public class GradientStop {
	
	private double offset = 0;
	private double opacity = 1.0;
	private String color = "";
	private String className = "";
	
	GradientStop() {
		this(0, 1.0, "white");
	}
	
	GradientStop(double offsetPct, double opacity, String color) {
		offset = offsetPct;
		this.opacity = opacity;
		this.color = color;
	}
	
	public void setOffset(double pct) {
		offset = Math.min(100, Math.max(0, pct));
	}
	
	public double getOffset() {
		return offset;
	}
	
	public void setColor(String color) {
		if(color == null) color = "";
		this.color = color;
	}
	
	public void setOpacity(double opacity) {
		this.opacity = offset = Math.min(1, Math.max(0, opacity));
	}
	
	public double getOpacity() {
		return opacity;
	}
	
	public void setClassName(String cls) {
		if(cls == null) cls = "";
		this.className = cls;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getColor() {
		return color;
	}
	
	public String toSVGString() {
		String tag = "<stop ";
		
		if(!className.isEmpty()) {
			tag += "class=\"" + className + "\" ";
		}
		
		if(opacity != 1.0) {
			tag += "stop-opacity=\"" + opacity + "\" ";
		}
		
		if(!color.isEmpty()) {
			tag += "stop-color=\"" + color + "\" ";
		}
		
		tag += "offset=\"" + offset + "%\" ";
		
		tag += "/>";
		return tag;
	}
	
}