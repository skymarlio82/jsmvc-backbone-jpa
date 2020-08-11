package com.spa.demo.api.controller;

import com.spa.demo.api.dto.ErrRtnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrRtnResult> handleAllException(Exception ex) {
        ErrRtnResult result = new ErrRtnResult();
        logger.error(ex.getMessage());
        ex.printStackTrace();
        result.getModelState().put("ERROR", ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}