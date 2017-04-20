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
package org.vaadin.addon.gwtgraphics.client.shape;

import org.vaadin.addon.gwtgraphics.client.Shape;
import org.vaadin.addon.gwtgraphics.client.VectorObject;

/**
 * Ellipse represents an ellipse.
 * 
 * @author Henri Kerola
 * 
 */
public class Ellipse extends Shape {

	/**
	 * Creates a new Ellipse with the given position and radius properties.
	 * 
	 * @param cx
	 *            the x-coordinate position of the center of the ellipse in
	 *            pixels
	 * @param cy
	 *            the y-coordinate position of the center of the ellipse in
	 *            pixels
	 * @param radiusX
	 *            the x-axis radius of the ellipse in pixels
	 * @param radiusY
	 *            the y-axis radius of the ellipse in pixels
	 */
	public Ellipse(double cx, double cy, double radiusX, double radiusY) {
		setCenter(cx,cy);
		setRadius(radiusX, radiusY);
	}
	
	public void setCenter(double x, double y) {
		setPropertyDouble("cx", x);
		setPropertyDouble("cy", y);
	}
	
	public double getCX() {
		return getPropertyDouble("cx");
	}
	
	public double getCY() {
		return getPropertyDouble("cy");
	}
	
	public void setRadius(double rx, double ry) {
		setPropertyDouble("rx", rx);
		setPropertyDouble("ry", ry);
	}
	
	public double getRadiusX() {
		return getPropertyDouble("rx");
	}
	
	public double getRadiusY() {
		return getPropertyDouble("ry");
	}

	@Override
	protected Class<? extends VectorObject> getType() {
		return Ellipse.class;
	}

	@Override
	public String getSVGElementName() {
		return "ellipse";
	}

}
