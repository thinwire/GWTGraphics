package org.vaadin.addon.gwtgraphics.testapp.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vaadin.addon.gwtgraphics.client.VectorObject;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DashEditor extends HorizontalPanel{

	TextBox dash;
	Button add;
	List<Double> dashes;
	Label dashLabel;
	Button setButton;
	VectorObject target;
	public DashEditor() {
		dash = new TextBox();
		add(new Label("Dash width:"));
		add(dash);
		add = new Button("Add");
		add(add);
		dashes = new ArrayList<>();
		dashLabel = new Label("");
		add(dashLabel);

		add.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				try{
					String s = dash.getValue();
					if(s == null) {
						return;
					}
					Double d = Double.valueOf(s);
					dashes.add(d);
				} catch(NumberFormatException e){
					GWT.log("The dash was not a number" + e.getLocalizedMessage());
					return;
				}

				if(dashes.isEmpty()) {
					dashLabel.setText("");
				}
				String str = "Dashes: [";
				Iterator<Double> it = dashes.iterator();

				Double dash = it.next();
				str+=dash.toString();
				while(it.hasNext()) {
					str+=",";
					dash = it.next();
					str+= dash.toString();
				}
				str+="]";
				dashLabel.setText(str);
			}

		});

		setButton = new Button("Set dashes");
		add(setButton);
		setSpacing(3);
		setButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				if(target!=null){
					if(!dashes.isEmpty()){
						target.getStroke().setDashArray(dashes);
					}
				}

			}

		});
	}

	public List<Double> getDashes() {
		return dashes;
	}

	public void setTarget(VectorObject target){
		this.target = target;
	}

}
