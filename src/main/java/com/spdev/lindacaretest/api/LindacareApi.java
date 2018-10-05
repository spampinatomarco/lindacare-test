package com.spdev.lindacaretest.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePostResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Rest API definition
 * 
 * @author marco
 *
 */
@Api(value = "Lindacare backend api.")
public interface LindacareApi {

	public static final String MESSAGES_PATH = "/messages";

	/**
	 * Allows users to post messages
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "Allows users to post messages", response = ApiMarketMessagePostResponse.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Message save."), 
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Provided credentials can't be authenticated."),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"), 
			@ApiResponse(code = 500, message = "Error occured.") })
	@PostMapping(value = MESSAGES_PATH, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	ResponseEntity<ApiMarketMessagePostResponse> postMessage(@RequestBody ApiMarketMessagePostRequest request);
}
