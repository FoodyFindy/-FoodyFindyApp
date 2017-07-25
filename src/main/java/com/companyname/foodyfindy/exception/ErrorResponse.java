/*------------------------------------------------------------------------------
 *******************************************************************************
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.companyname.foodyfindy.exception;

public class ErrorResponse {
	
	
	private int errorCode;
	
	private String message;
	
	/**
	 * 
	 */
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ErrorResponse(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}




	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
