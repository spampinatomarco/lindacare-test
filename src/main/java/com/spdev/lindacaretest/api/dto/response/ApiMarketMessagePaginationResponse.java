package com.spdev.lindacaretest.api.dto.response;

import org.springframework.data.domain.Page;

import com.spdev.lindacaretest.api.dto.ApiMarketMessage;
import com.spdev.lindacaretest.api.dto.DefaultApiResponse;

/**
 * ApiMarketMessagePostResponse
 * 
 * @author marco
 *
 */
public class ApiMarketMessagePaginationResponse extends DefaultApiResponse {

	private static final long serialVersionUID = -2749486205919367775L;

	private Page<ApiMarketMessage> marketMessages;

	/**
	 * @return the marketMessages
	 */
	public Page<ApiMarketMessage> getMarketMessages() {
		return marketMessages;
	}

	/**
	 * @param marketMessages
	 *            the marketMessages to set
	 */
	public void setMarketMessages(Page<ApiMarketMessage> marketMessages) {
		this.marketMessages = marketMessages;
	}

}
