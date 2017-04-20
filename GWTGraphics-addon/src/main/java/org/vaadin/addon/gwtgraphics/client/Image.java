/*
 * Copyright 2011 Henri Kerola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.addon.gwtgraphics.client;

import org.vaadin.addon.gwtgraphics.client.animation.Animatable;

/**
 * Image represents a raster image that can be embedded into DrawingArea.
 * 
 * @author Henri Kerola
 * 
 */
public class Image extends VectorObject implements Animatable {

	/**
	 * Create a new Image with the given properties.
	 * 
	 * @param x
	 *            the x-coordinate position of the top-left corner of the image
	 *            in pixels
	 * @param y
	 *            the y-coordinate position of the top-left corner of the image
	 *            in pixels
	 * @param width
	 *            the width of the image in pixels
	 * @param height
	 *            the height of the image in pixels
	 * @param href
	 *            URL to an image to be shown.
	 */
	public Image(int x, int y, int width, int height, String href) {
		setPosition(x,y);
		setSize(width,height);
		setHref(href);
	}

	@Override
	protected Class<? extends VectorObject> getType() {
		return Image.class;
	}

	/**
	 * Returns the URL of the image currently shown.
	 * 
	 * @return URL of the image
	 */
	public String getHref() {
		return getProperty("href", "");
	}

	/**
	 * Sets the URL of the image to be shown.
	 * 
	 * @param href
	 *            URL of the image to be shown
	 */
	public void setHref(String href) {
		setProperty("href", href);
		redraw();
	}

	@Override
	public String getSVGElementName() {
		return "image";
	}

	
}