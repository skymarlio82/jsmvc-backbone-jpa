
package com.spa.demo.rest.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ErrRtnResult {

	private Map<String, String> modelState = new HashMap<String, String>();

	public ErrRtnResult() {
		
	}
}