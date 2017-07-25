/**
 * 
 */
package com.companyname.foodyfindy.exception;

import org.springframework.http.HttpStatus;

/**
 * @author lingadal
 *
 */
public class FoodyFindyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private HttpStatus status;
	
	public FoodyFindyException(HttpStatus status,int errorCode ,String errorMessage){
		super(errorMessage);
		this.status=status;
		this.errorCode=errorCode;
	}

	public int getErrorcode(){
		return errorCode;
	}
	public HttpStatus getHttpStatus(){
		return status;
	}
}
