package com.spdev.lindacaretest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePostResponse;

/**
 * Rest API implementation
 * 
 * @author marco
 *
 */
@RestController
public class LindacareApiImpl implements LindacareApi {

	@Override
	public ResponseEntity<ApiMarketMessagePostResponse> postMessage(ApiMarketMessagePostRequest request) {
		ApiMarketMessagePostResponse response = new ApiMarketMessagePostResponse();
		return new ResponseEntity<ApiMarketMessagePostResponse>(response, HttpStatus.OK);
	}

}
