package com.spdev.lindacaretest.api.interceptor;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spdev.lindacaretest.api.dto.DefaultApiResponse;
import com.spdev.lindacaretest.exception.InvalidApiParameterException;
import com.spdev.lindacaretest.exception.JwtAuthentificationException;

/**
 * It will intercept all the exception from the API and format it depending on the exception throw by the services
 * 
 * @author marco
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String ERROR_MESSAGE = "Error";
	private static final String ERROR_MESSAGE_EXCEPTION = "Error a error";

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleServerException(Exception ex, WebRequest request) {
		logger.error("Caught exception:", ex);

		DefaultApiResponse result = new DefaultApiResponse();
		result.setMessage(String.format(ERROR_MESSAGE_EXCEPTION));

		return new ResponseEntity<Object>(result, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ JwtAuthentificationException.class })
	public ResponseEntity<Object> handleAuthenticateException(Exception ex, WebRequest request) {
		logger.error("Caught JwtAuthentificationException exception:", ex);

		DefaultApiResponse result = generateExceptionResult(ex);
		return new ResponseEntity<Object>(result, new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler({ InvalidApiParameterException.class })
	public ResponseEntity<Object> handleProcessApiRequestException(Exception ex, WebRequest request) {
		logger.error("Caught InvalidApiParameterException:", ex);

		DefaultApiResponse result = generateExceptionResult(ex);
		return new ResponseEntity<Object>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	private DefaultApiResponse generateExceptionResult(Exception ex) {
		DefaultApiResponse result = new DefaultApiResponse();

		result.setMessage(ex.getMessage());

		if (Strings.isEmpty(result.getMessage())) {
			result.setMessage(ERROR_MESSAGE);
		}
		return result;
	}
}