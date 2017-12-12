package org.vaadin.addon.gwtgraphics.testapp.client;

import org.vaadin.addon.gwtgraphics.client.DrawingArea;
import org.vaadin.addon.gwtgraphics.client.bundle.GWTGraphicsConstants;
import org.vaadin.addon.gwtgraphics.client.shape.Rectangle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InteractiveTestApplication extends HorizontalPanel {

	private Metadata metadata;

	private final DrawingArea area;

	private final EditorPanel editPanel;

	private CodeView code;

	Rectangle topRec = new Rectangle(20, 50, 150, 100);
	Rectangle bottomRec = new Rectangle(80, 80, 150, 150);

	public InteractiveTestApplication() {
		metadata = new Metadata(this);

		VerticalPanel vPanel = new VerticalPanel();
		add(vPanel);

		area = new DrawingArea(400, 600);
		area.setStyleName("drawing-area");
		vPanel.add(area);
		vPanel.add(new Label("Using " + area.getRendererString()
				+ " rendering. Version: " + getVersion()));
		DisclosurePanel sourceCodePanel = new DisclosurePanel("Source code");
		sourceCodePanel.setAnimationEnabled(true);
		code = new CodeView(metadata);
		sourceCodePanel.setContent(code);
		vPanel.add(sourceCodePanel);

		Button b = new Button("Clear");
		vPanel.add(b);
		b.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				area.clear();
			}
		});

		editPanel = new EditorPanel(metadata);
		add(editPanel);

		bottomRec.addMouseMoveHandler(event -> {
			consoleLog("mousemove");
		});
		bottomRec.addClickHandler(event -> {
			consoleLog("click");
		});
		bottomRec.addMouseOutHandler(event -> {
			consoleLog("out");
		});
		bottomRec.addDoubleClickHandler(event -> {
			consoleLog("doubleclick");
		});
		bottomRec.addMouseDownHandler(event -> {
			consoleLog("mousedown");
		});
		bottomRec.addMouseOverHandler(event -> {
			consoleLog("mouseover");
		});
		bottomRec.addMouseUpHandler(event -> {
			consoleLog("mouseup");
		});

		area.add(bottomRec);
		area.add(topRec);

		bottomRec.redraw();
		topRec.redraw();

	}

	native void consoleLog( String message) /*-{
            console.log( "me:" + message );
        }-*/;


	private String getVersion() {
		GWTGraphicsConstants constants = GWT.create(GWTGraphicsConstants.class);
		return constants.version();
	}

	public CodeView getCodeView() {
		return code;
	}

	public DrawingArea getDrawingArea() {
		return area;
	}
}
