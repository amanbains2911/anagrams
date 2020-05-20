/**
 * 
 */
package com.aman.viafoura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author amanb
 *
 */
@ControllerAdvice
public class AnagramsException extends Throwable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6180121444555560532L;

	@ExceptionHandler(AnagramsException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleDefaultException(Throwable ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex);
        errorResponse.setErrorMessage("String1 is not valid");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
