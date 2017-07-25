/**
 * 
 */
package com.companyname.foodyfindy.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lingadal
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FoodyFindyException.class)
	public ResponseEntity<ErrorResponse> handleFoodyFindyException(HttpServletRequest request,
			FoodyFindyException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getErrorcode(), exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, exception.getHttpStatus());
	}

}
