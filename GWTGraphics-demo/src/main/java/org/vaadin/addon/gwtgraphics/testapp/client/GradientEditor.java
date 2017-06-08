package org.vaadin.addon.gwtgraphics.testapp.client;

import java.util.List;

import org.vaadin.addon.gwtgraphics.client.Shape;
import org.vaadin.addon.gwtgraphics.client.gradient.Gradient;
import org.vaadin.addon.gwtgraphics.client.gradient.GradientStop;
import org.vaadin.addon.gwtgraphics.client.gradient.LinearGradient;
import org.vaadin.addon.gwtgraphics.client.gradient.RadialGradient;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GradientEditor extends HorizontalPanel{

	ListBox gradientType;
	Button setButton;
	GradientDetails details;
	Shape target;

	public static final String LINEAR_GRADIENT = "linear-gradient";
	public static final String RADIAL_GRADIENT = "radial-gradient";


	public GradientEditor() {
		gradientType = new ListBox();
		gradientType.setTitle("Gradient type:");
		add(gradientType);
		setSpacing(3);
		gradientType.addChangeHandler(e -> {
			if(e.getSource() == gradientType) {
				String type = gradientType.getSelectedValue();
				clear();
				if(LINEAR_GRADIENT.equals(type)) {
					add(gradientType);
					details = GWT.create(LinearGradientDetails.class);
					add(details);
					add(setButton);

				} else if(RADIAL_GRADIENT.equals(type)) {
					add(gradientType);
					details = GWT.create(RadialGradientDetails.class);
					add(details);
					add(setButton);
				}
			}
		});

		setButton = new Button("Set gradient");
		add(setButton);
		setButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(target!=null){
					target.setFill(getGradient());
				}
				details.add(new Label("Gradient added to Shape"));

			}

		});
	}

	public void setTarget(Shape target){
		this.target = target;
	}

	public void addProperties(String[] properties) {
		for (String property : properties) {
			gradientType.addItem(property);
		}
		gradientType.addItem("");
		gradientType.setSelectedIndex(gradientType.getItemCount()-1);
	}

	public Gradient getGradient() {
		if(details != null) {
			return details.getGradient();
		}
		return null;
	}

	public static abstract class GradientDetails extends VerticalPanel{
		StopEditor stopEditor;

		public GradientDetails() {
			stopEditor = GWT.create(StopEditor.class);
			setSpacing(3);
		}

		public abstract Gradient getGradient();
	}


	static class LinearGradientDetails extends GradientDetails {
		TextBox x0, y0, x1, y1;


		public LinearGradientDetails() {
			HorizontalPanel panel = new HorizontalPanel();
			x0 = new TextBox();
			x0.setTitle("x0:");
			x0.setVisibleLength(3);
			panel.add(new Label("x0: "));
			panel.add(x0);

			x1 = new TextBox();
			x1.setTitle("x1:");
			x1.setVisibleLength(3);
			panel.add(new Label("x1: "));
			panel.add(x1);

			y0 = new TextBox();
			y0.setTitle("y0:");
			y0.setVisibleLength(3);
			panel.add(new Label("y0: "));
			panel.add(y0);

			y1 = new TextBox();
			y1.setTitle("y1:");
			y1.setVisibleLength(3);
			panel.add(new Label("y1: "));
			panel.add(y1);
			add(panel);
			add(stopEditor);

		}

		@Override
		public Gradient getGradient() {
			try {
				double xx0 = Double.valueOf(x0.getValue());
				double xx1 = Double.valueOf(x1.getValue());
				double yy0 = Double.valueOf(y0.getValue());
				double yy1 = Double.valueOf(y1.getValue());
				LinearGradient gradient = new LinearGradient(xx0, yy0, xx1, yy1);
				List<GradientStop> stops = stopEditor.getStops();
				for(GradientStop stop : stops) {
					gradient.addStop(stop);
				}
				return gradient;
			} catch (NumberFormatException e) {
				GWT.log("One of the fields did not contain a nuber" + e.getLocalizedMessage());;
			}
			return null;
		}
	}

	static class RadialGradientDetails extends GradientDetails{
		TextBox cx, cy, fx, fy, radius;

		public RadialGradientDetails() {
			HorizontalPanel panel = new HorizontalPanel();
			cx = new TextBox();
			cx.setTitle("cx:");
			cx.setVisibleLength(3);
			panel.add(new Label("cx: "));
			panel.add(cx);

			cy = new TextBox();
			cy.setTitle("cy:");
			cy.setVisibleLength(3);
			panel.add(new Label("cy: "));
			panel.add(cy);

			fx = new TextBox();
			fx.setTitle("fx:");
			fx.setVisibleLength(3);
			panel.add(new Label("fx: "));
			panel.add(fx);

			fy = new TextBox();
			fy.setTitle("fy:");
			fy.setVisibleLength(3);
			panel.add(new Label("fy: "));
			panel.add(fy);

			radius = new TextBox();
			radius.setTitle("radius:");
			radius.setVisibleLength(3);
			panel.add(new Label("radius: "));
			panel.add(radius);
			add(panel);
			add(stopEditor);
		}

		@Override
		public Gradient getGradient() {
			try {
				double cxx = Double.valueOf(cx.getValue());
				double cyy = Double.valueOf(cy.getValue());
				double fxx = Double.valueOf(fx.getValue());
				double fyy = Double.valueOf(fy.getValue());
				double r = Double.valueOf(radius.getValue());
				RadialGradient gradient =  new RadialGradient(cxx, cyy, fxx, fyy, r);
				List<GradientStop> stops = stopEditor.getStops();
				for(GradientStop stop : stops) {
					gradient.addStop(stop);
				}
				return gradient;
			} catch (NumberFormatException e) {

			}
			return null;
		}
	}

}
