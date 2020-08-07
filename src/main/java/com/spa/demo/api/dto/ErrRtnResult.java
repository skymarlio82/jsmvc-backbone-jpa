package com.spa.demo.api.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrRtnResult {

    private Map<String, String> modelState = new HashMap<String, String>();

    public ErrRtnResult() {

    }
}