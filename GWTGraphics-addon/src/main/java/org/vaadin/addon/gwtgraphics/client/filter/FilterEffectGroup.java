package org.vaadin.addon.gwtgraphics.client.filter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Abstraction for the feMerge node 
 */
public class FilterEffectGroup {

	private final Set<FilterEffect> effects;
	
	public FilterEffectGroup() {
		effects = new LinkedHashSet<FilterEffect>();
	}
	
	public boolean isTrivial() {
		return effects.size() < 2;
	}
	
	public void add(FilterEffect e) {
		effects.add(e);
	}
	
	public void remove(FilterEffect e) {
		effects.remove(e);
	}
	
	/**
	 * Generate the SVG DOM string for this filter group
	 * @return a bunch of SVG dom statements
	 */
	public String toSVGString() {
		String tag = "<feMerge>";
		for(FilterEffect f : effects) {
			tag += "<feMergeNode in=\"" + f.getResult() + "\">";
		}
		tag += "</feMerge>";
		
		return tag;
	}
	
}
