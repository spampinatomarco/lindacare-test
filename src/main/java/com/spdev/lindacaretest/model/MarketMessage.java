package com.spdev.lindacaretest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model from Collection market_message It will store message from the market
 * made by users
 * 
 * @author marco
 *
 */
@Document(collection = "market_message")
public class MarketMessage extends AbstractModel implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

	@Field("id")
	@Indexed(unique = true, background = true)
	private Long id;

	@Field("user_id")
	private Long userId;

	@Field("currency_from")
	private Currency currencyFrom;

	@Field("currency_to")
	private Currency currencyTo;

	@Field("originating_country")
	private String originatingCountry;

	@Field("amount_sell")
	private BigDecimal amountSell;

	@Field("amount_buy")
	private BigDecimal amountBuy;

	@Field("rate")
	private BigDecimal rate;

	@Field("time_placed")
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
