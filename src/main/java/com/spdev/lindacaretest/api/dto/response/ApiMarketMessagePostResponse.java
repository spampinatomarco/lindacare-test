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
public class ApiMarketMessagePostResponse extends DefaultApiResponse {

	private static final long serialVersionUID = -2749486205919367775L;

	private ApiMarketMessage marketMessage;

	/**
	 * @return the marketMessage
	 */
	public ApiMarketMessage getMarketMessage() {
		return marketMessage;
	}

	/**
	 * @param marketMessage
	 *            the marketMessage to set
	 */
	public void setMarketMessage(ApiMarketMessage marketMessage) {
		this.marketMessage = marketMessage;
	}

}
