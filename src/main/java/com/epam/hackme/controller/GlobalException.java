package com.epam.hackme.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error";
	}
}
