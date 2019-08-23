
package com.spa.demo.mvc.rest.model;

import java.util.HashMap;
import java.util.Map;

public class ErrRtnResult {

	private Map<String, String> modelState = new HashMap<String, String>();

	public ErrRtnResult() {
		
	}

	public Map<String, String> getModelState() {
		return modelState;
	}

	public void setModelState(Map<String, String> modelState) {
		this.modelState = modelState;
	}
}