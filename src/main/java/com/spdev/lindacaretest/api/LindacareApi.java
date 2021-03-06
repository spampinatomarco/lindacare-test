package com.spdev.lindacaretest.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePaginationResponse;
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

	public final static int MAX_PAGE_SIZE = 100;

	public static final String MESSAGES_PATH = "/messages";

	/**
	 * Allows users to post messages
	 * 
	 * @param request
	 * @return
	 */
	// I don't finish the swagger configuration, I will focus on the front end
	@ApiOperation(value = "Allows users to post MarketMessages", response = ApiMarketMessagePostResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Message save."), @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Provided credentials can't be authenticated."),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"), @ApiResponse(code = 500, message = "Error occured.") })
	@PostMapping(value = MESSAGES_PATH, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	ResponseEntity<ApiMarketMessagePostResponse> postMarketMessage(@RequestBody ApiMarketMessagePostRequest request);

	/**
	 * Return the MarketMessage with a pagination
	 * @param pageable
	 * @return
	 */
	// I don't finish the swagger configuration, I will focus on the front end
	@ApiOperation(value = "Get all MarketMessage with pagination")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Message save."), @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Provided credentials can't be authenticated."),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"), @ApiResponse(code = 500, message = "Error occured.") })
	@GetMapping(value = MESSAGES_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiMarketMessagePaginationResponse> getMarketMessages(Pageable pageable);
}
