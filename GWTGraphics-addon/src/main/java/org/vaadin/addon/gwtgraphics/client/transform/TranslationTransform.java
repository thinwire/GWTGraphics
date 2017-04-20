package org.vaadin.addon.gwtgraphics.client.transform;

public class TranslationTransform extends Transform {

	public TranslationTransform(double tx, double ty) {
		super(TransformType.TRANSLATE, tx, ty);
	}
	
	public void set(double tx, double ty) {
		setValue(0, tx);
		setValue(1, ty);
	}
	
	public double getX() {
		return getValue(0);
	}
	
	public double getY() {
		return getValue(1);
	}
	
}
