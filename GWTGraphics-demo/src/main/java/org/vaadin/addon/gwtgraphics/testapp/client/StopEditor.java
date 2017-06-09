package org.vaadin.addon.gwtgraphics.testapp.client;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.addon.gwtgraphics.client.gradient.GradientStop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StopEditor extends VerticalPanel{

	private TextBox offset, opacity, color;
	private Button add;
	List<GradientStop> stops;
	VerticalPanel stopsHolder;
	public StopEditor() {
		stops = new ArrayList<>();
		offset = new TextBox();
		offset.setVisibleLength(3);
		opacity = new TextBox();
		opacity.setVisibleLength(3);
		color = new TextBox();
		color.setVisibleLength(10);
		add = new Button("Add");
		HorizontalPanel editor = new HorizontalPanel();
		editor.add(new Label("Color: "));
		editor.add(color);
		editor.add(new Label("Offset: "));
		editor.add(offset);
		editor.add(new Label("Opacity: "));
		editor.add(opacity);
		editor.add(add);
		add(editor);

		stopsHolder = new VerticalPanel();
		add(stopsHolder);
		add.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				try{
					String c = color.getValue();
					double of = Double.valueOf(offset.getValue() == null ? "" : offset.getValue());
					double op = Double.valueOf(opacity.getValue() == null ? "1" : opacity.getValue());
					stops.add(new GradientStop(of, op, c));
					renderStops();
				} catch(NumberFormatException e) {
					GWT.log("Failed to convert to numbers: " + e.getLocalizedMessage());
				}


			}

		});

	}

	public List<GradientStop> getStops() {
		return stops;
	}

	public void renderStops() {
		stopsHolder.clear();
		for(GradientStop stop: stops) {
			stopsHolder.add(new Label("Stop with offset: " + stop.getOffset() + " color: " + stop.getColor() + " and opacity: " + stop.getOpacity()));

		}
	}

}
