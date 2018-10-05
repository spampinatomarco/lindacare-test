package com.spdev.lindacaretest.api.dto.response;

import java.util.List;

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

	private List<ApiMarketMessage> marketMessages;

	/**
	 * @return the marketMessages
	 */
	public List<ApiMarketMessage> getMarketMessages() {
		return marketMessages;
	}

	/**
	 * @param marketMessages
	 *            the marketMessages to set
	 */
	public void setMarketMessages(List<ApiMarketMessage> marketMessages) {
		this.marketMessages = marketMessages;
	}
}
