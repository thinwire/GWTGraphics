package org.vaadin.addon.gwtgraphics.client.filter;

public class Filter {

	private static int INSTANCE_COUNT = 0;
	
	private FilterEffectGroup effects;
	private String id;
	
	public Filter() {
		id = "filter_" + (++INSTANCE_COUNT);
		effects = new FilterEffectGroup();
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void addEffect(FilterEffect e) {
		effects.add(e);
	}
	
	public void removeEffect(FilterEffect e) {
		effects.remove(e);
	}
	
	public String toSVGString() {
		String tag = "<filter id=\"" + id + "\"";
		
		return tag;
	}
	
}
