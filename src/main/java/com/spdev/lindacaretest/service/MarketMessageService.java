package com.spdev.lindacaretest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spdev.lindacaretest.model.MarketMessage;

/**
 * Services for the MarketMessage model
 * 
 * @author marco
 *
 */
public interface MarketMessageService {

	/**
	 * Create a MarketMessage
	 * 
	 * @param marketMessage
	 * @return
	 */
	public MarketMessage createMarketMessage(MarketMessage marketMessage);

	/**
	 * Return a Page with the MarketMessage
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<MarketMessage> findAll(Pageable pageable);

}
