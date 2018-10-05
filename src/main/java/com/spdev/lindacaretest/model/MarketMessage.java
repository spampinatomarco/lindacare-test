package com.spdev.lindacaretest.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model from Collection market_message It will store message from the market
 * made by users
 * 
 * @author marco
 *
 */
@Document(collection = "market_message")
public class MarketMessage implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	private String id;

}
