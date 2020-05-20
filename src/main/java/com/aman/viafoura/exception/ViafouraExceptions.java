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
public class ViafouraExceptions extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2402195188693121245L;

	@ExceptionHandler(ViafouraExceptions.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleDefaultException(Throwable ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex);
        errorResponse.setErrorMessage("Either string1 or string2 are not valid");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
	

}
