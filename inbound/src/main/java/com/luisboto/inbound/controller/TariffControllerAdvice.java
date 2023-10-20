package com.luisboto.inbound.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.luisboto.core.exception.NoActiveTariffFoundException;

@ControllerAdvice
public class TariffControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NoActiveTariffFoundException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        if (ex instanceof NoActiveTariffFoundException)
        	return ResponseEntity.badRequest().body(ex.getMessage());
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}