package org.vaadin.addon.gwtgraphics.testapp.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.vaadin.addon.gwtgraphics.client.VectorObject;
import org.vaadin.addon.gwtgraphics.client.filter.Filter;
import org.vaadin.addon.gwtgraphics.client.filter.FilterEffect;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FilterEditor extends VerticalPanel{

	ListBox filterType;
	Button addEffectButton;
	Button addFilterButton;
	ParameterEditor filterParams;
	List<EffectEditor> filterEditors;
	VerticalPanel filterEditorLayout;
	VectorObject target;


	public FilterEditor() {
		HorizontalPanel fp = new HorizontalPanel();
		fp.setSpacing(3);
		fp.add(new Label("Filter parameters: "));
		filterParams = new ParameterEditor();
		fp.add(filterParams);
		setSpacing(3);
		addEffectButton = new Button("Add effect");
		fp.add(addEffectButton);
		addEffectButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				filterEditorLayout.clear();
				filterEditors.add(new EffectEditor());
				for(EffectEditor f: filterEditors) {
					filterEditorLayout.add(f);
				}

			}

		});
		addFilterButton = new Button("Set filter");
		fp.add(addFilterButton);
		add(fp);
		addFilterButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				Filter f =  getFilter();
				target.setFilter(f);

			}

		});

		filterEditors = new ArrayList<>();
		filterEditorLayout = new VerticalPanel();
		add(filterEditorLayout);


	}

	public void setTarget(VectorObject shape) {
		target = shape;
	}

	public Filter getFilter() {
		if(filterEditors.isEmpty()) {
			return null;
		}
		Filter f = new Filter();
		for(Entry<String,String> entry: filterParams.getParams().entrySet()) {
			f.setParameter(entry.getKey(), entry.getValue());
		}
		for(EffectEditor fe: filterEditors ) {
			f.addEffect(fe.getEffect());
		}
		return f;
	}


	public static class ParameterEditor extends HorizontalPanel {
		TextBox key;
		TextBox value;
		Button add;
		Label paramLabel;

		LinkedHashMap<String,String> params;

		public ParameterEditor() {
			key = new TextBox();
			key.setTitle("key");
			key.setVisibleLength(10);
			add(new Label("key"));
			add(key);

			value = new TextBox();
			value.setTitle("value");
			value.setVisibleLength(5);
			add(new Label("value"));
			add(value);

			add = new Button("Add parameter");
			add(add);
			add.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					String k = key.getValue();
					String v = value.getValue();
					if(k == null || k.isEmpty()) {
						return;
					}
					if(v == null || v.isEmpty()) {
						params.remove(k);
					} else {
						params.put(k, v);
					}
					renderParams();

				}

			});

			params = new LinkedHashMap<>();
			paramLabel=new Label("");
			add(paramLabel);

		}

		public void renderParams() {
			if(params.isEmpty()) {
				return;
			}
			Iterator<Entry<String,String>> it = params.entrySet().iterator();
			String str = "Paramters: ";

			Entry<String,String> entry = it.next();
			str += entry.getKey() + "=" + entry.getValue();
			while(it.hasNext()) {
				str+=", ";
				entry = it.next();
				str += entry.getKey() + "=" + entry.getValue();
			}
			paramLabel.setText(str);
		}

		public Map<String,String> getParams() {
			return params;
		}
	}

	public static class EffectEditor extends HorizontalPanel{
		ListBox effect;
		ParameterEditor params;

		public EffectEditor() {
			effect = new ListBox();
			effect.addItem("feBlend");
			effect.addItem("feGaussianBlur");
			effect.addItem("feFlood");
			effect.addItem("feImage");
			effect.addItem("feOffset");
			effect.addItem("feTurbulence");
			effect.addItem("feDisplacementMap");
			effect.addItem("");

			add(new Label("Effect:"));
			add(effect);
			params = new ParameterEditor();
			add(params);
		}

		public FilterEffect getEffect() {
			if(effect.getSelectedValue() == null || effect.getSelectedValue().isEmpty()) {
				return null;
			}
			FilterEffect e = new FilterEffect(effect.getSelectedValue());
			for (Entry<String,String> entry: params.getParams().entrySet()){
				e.setParameter(entry.getKey(), entry.getValue());
			}
			return e;
		}
	}

}
