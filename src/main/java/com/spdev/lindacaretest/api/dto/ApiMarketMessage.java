package com.spdev.lindacaretest.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spdev.lindacaretest.utils.converter.JsonLocalDateTimeDeSerializer;
import com.spdev.lindacaretest.utils.converter.JsonLocalDateTimeSerializer;

/**
 * DTO for the API to the Model MarketMessage
 * 
 * @author marco
 *
 */
public class ApiMarketMessage implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

	private Long id;

	private Long userId;

	private Currency currencyFrom;

	private Currency currencyTo;

	private String originatingCountry;

	private BigDecimal amountSell;

	private BigDecimal amountBuy;

	private BigDecimal rate;

	@JsonSerialize(using = JsonLocalDateTimeSerializer.class)
	@JsonDeserialize(using = JsonLocalDateTimeDeSerializer.class)
	private LocalDateTime timePlaced;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the currencyFrom
	 */
	public Currency getCurrencyFrom() {
		return currencyFrom;
	}

	/**
	 * @param currencyFrom
	 *            the currencyFrom to set
	 */
	public void setCurrencyFrom(Currency currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	/**
	 * @return the currencyTo
	 */
	public Currency getCurrencyTo() {
		return currencyTo;
	}

	/**
	 * @param currencyTo
	 *            the currencyTo to set
	 */
	public void setCurrencyTo(Currency currencyTo) {
		this.currencyTo = currencyTo;
	}

	/**
	 * @return the originatingCountry
	 */
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	/**
	 * @param originatingCountry
	 *            the originatingCountry to set
	 */
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	/**
	 * @return the amountSell
	 */
	public BigDecimal getAmountSell() {
		return amountSell;
	}

	/**
	 * @param amountSell
	 *            the amountSell to set
	 */
	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	/**
	 * @return the amountBuy
	 */
	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	/**
	 * @param amountBuy
	 *            the amountBuy to set
	 */
	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the timePlaced
	 */
	public LocalDateTime getTimePlaced() {
		return timePlaced;
	}

	/**
	 * @param timePlaced
	 *            the timePlaced to set
	 */
	public void setTimePlaced(LocalDateTime timePlaced) {
		this.timePlaced = timePlaced;
	}

}
