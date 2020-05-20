/**
 * 
 */
package com.aman.viafoura.exception;

/**
 * @author amanb
 *
 */
public class ErrorResponse {

	public ErrorResponse(Throwable ex) {
		super();
	}
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	

}
