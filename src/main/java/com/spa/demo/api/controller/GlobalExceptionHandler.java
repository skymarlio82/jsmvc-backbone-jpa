
package com.spa.demo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spa.demo.api.dto.ErrRtnResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ErrRtnResult> handleAllException(Exception ex) {
		ErrRtnResult result = new ErrRtnResult();
		log.error(ex.getMessage());
		ex.printStackTrace();
		result.getModelState().put("ERROR", ex.getMessage());
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}