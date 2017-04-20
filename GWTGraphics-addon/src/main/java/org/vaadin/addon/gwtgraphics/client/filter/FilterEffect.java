package org.vaadin.addon.gwtgraphics.client.filter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FilterEffect {

	private static int INSTANCE_COUNT = 0;
	
	public static enum InputSource {
		SOURCE_GRAPHIC,
		CUSTOM
	}

	private Map<String, String> parameters;
	private InputSource inputSource = InputSource.SOURCE_GRAPHIC;
	private String input;
	private String result;
	private String id;
	private String tag;
	
	protected FilterEffect(String tag) {
		this.tag = tag;
		parameters = new LinkedHashMap<String,String>();
		id = "filter_effect_" + (++INSTANCE_COUNT);
		result = id;
	}
	
	public String getID() {
		return id;
	}

	public void setInput(String s) {
		if(s == null) {
			inputSource = InputSource.SOURCE_GRAPHIC;
			input = "SourceGraphic";
		} else {
			inputSource = InputSource.CUSTOM;
			input = s;
		}
	}
	
	public InputSource getInputSource() {
		return inputSource;
	}
	
	public String getInput() {
		return input;
	}

	public void setResult(String resultString) {
		result = resultString;
	}
	
	public String getResult() {
		return result;
	}
	
	/**
	 * Get current value of a previously set parameter
	 * 
	 * @param pname
	 *            name of parameter
	 * @return a String value or null
	 */
	public String getParameter(String pname) {
		return getParameter(pname, null);
	}

	/**
	 * Get the current value of a previously set parameter, or a default value
	 * if no value is currently set
	 * 
	 * @param pname
	 *            name of parameter
	 * @param defaultValue
	 *            value to return if no value has been set
	 * @return a String value
	 */
	public String getParameter(String pname, String defaultValue) {
		String value = parameters.get(pname);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * Set a parameter. If pvalue is null, the parameter is removed.
	 * 
	 * @param pname
	 *            name of parameter
	 * @param pvalue
	 *            value of parameter
	 */
	public void setParameter(String pname, String pvalue) {
		if (pvalue == null || pvalue.isEmpty()) {
			parameters.remove(pname);
		} else {
			parameters.put(pname, pvalue);
		}
	}

	/**
	 * Get the SVG string representation of this Filter Effect
	 * @return
	 */
	public String toSVGString() {
		String tag = "<" + this.tag + " ";
		tag += "in=\"" + input + "\" ";
		Iterator<String> it = parameters.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = parameters.get(key);
			tag += key + "=\"" + value + "\" ";
		}
		
		tag += "/>";
		return tag;
	}
	
}
