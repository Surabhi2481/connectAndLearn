package com.surabhi.connectAndLearn.exceptionalhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String handleError() {
		return "errorhandler";
	}

}
