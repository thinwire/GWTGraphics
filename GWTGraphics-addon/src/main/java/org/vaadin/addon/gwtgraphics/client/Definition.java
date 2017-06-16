package org.vaadin.addon.gwtgraphics.client;

import com.google.gwt.dom.client.Element;

/**
 * All filters and gradients should be defined in <defs> tags in SVG. This class
 * represents such a definition. It contains one method for getting the
 * definition. Note that definitions have to be explicitly added to the drawing
 * area. That is, it is not enough to add e.g. a gradient to a object, it is
 * also necessary to add it to the drawing area directly.
 *
 * @author Pontus Bostrom
 *
 */
public interface Definition {

	/**
	 * Returns the definition element
	 */
	public Element getElement();

}
