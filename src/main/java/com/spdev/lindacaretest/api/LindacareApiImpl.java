package com.spdev.lindacaretest.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePaginationResponse;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePostResponse;
import com.spdev.lindacaretest.mapper.MarketMessageMapper;
import com.spdev.lindacaretest.model.MarketMessage;
import com.spdev.lindacaretest.service.MarketMessageService;

/**
 * Rest API implementation
 * 
 * @author marco
 *
 */
@RestController
public class LindacareApiImpl implements LindacareApi {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MarketMessageService marketMessageService;

	@Autowired
	private MarketMessageMapper marketMessageMapper;
	
	@Override
	public ResponseEntity<ApiMarketMessagePostResponse> postMarketMessage(@RequestBody ApiMarketMessagePostRequest request) {

		// create the message
		MarketMessage createdMarketMessage = marketMessageService.createMarketMessage(marketMessageMapper.from(request));

		// Map the object created to the response
		ApiMarketMessagePostResponse response = new ApiMarketMessagePostResponse();
		response.setMarketMessage(marketMessageMapper.to(createdMarketMessage));

		return new ResponseEntity<ApiMarketMessagePostResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiMarketMessagePaginationResponse> getMarketMessages(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
