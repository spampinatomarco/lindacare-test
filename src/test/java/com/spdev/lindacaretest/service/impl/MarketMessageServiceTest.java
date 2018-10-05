package com.spdev.lindacaretest.service.impl;

import static org.hamcrest.CoreMatchers.is;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spdev.lindacaretest.exception.LindacareInvalidParameterException;
import com.spdev.lindacaretest.model.MarketMessage;
import com.spdev.lindacaretest.repo.MarketMessageRepository;
import com.spdev.lindacaretest.service.MarketMessageService;

/**
 * Test for the MarketMessageService
 * 
 * @author marco
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketMessageServiceTest {

	@Autowired
	private MarketMessageService marketMessageService;

	@Autowired
	private MarketMessageRepository marketMessageRepository;

	@Test
	public void should_createMarketMessage() throws Exception {

		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage = marketMessageService.createMarketMessage(marketMessage);

		Assert.assertNotNull(marketMessage.getId());

		MarketMessage marketMessageSaved = marketMessageRepository.getById(marketMessage.getId());

		Assert.assertThat(marketMessage.getUserId(), is(marketMessageSaved.getUserId()));
		Assert.assertThat(marketMessage.getAmountBuy(), is(marketMessageSaved.getAmountBuy()));
		Assert.assertThat(marketMessage.getAmountSell(), is(marketMessageSaved.getAmountSell()));
		Assert.assertThat(marketMessage.getRate(), is(marketMessageSaved.getRate()));
		Assert.assertThat(marketMessage.getCurrencyFrom(), is(marketMessageSaved.getCurrencyFrom()));
		Assert.assertThat(marketMessage.getCurrencyTo(), is(marketMessageSaved.getCurrencyTo()));
		Assert.assertThat(marketMessage.getTimePlaced(), is(marketMessageSaved.getTimePlaced()));
		Assert.assertThat(marketMessage.getOriginatingCountry(), is(marketMessageSaved.getOriginatingCountry()));
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_invalid_amountBuy() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setAmountBuy(new BigDecimal("-1"));

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_amountBuy() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setAmountBuy(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_invalid_amountSell() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setAmountSell(new BigDecimal("-1"));

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_amountSell() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setAmountSell(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_rate() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setRate(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_currencyFrom() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setCurrencyFrom(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_currencyTo() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setCurrencyTo(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_originatingCountry() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setOriginatingCountry(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_userId() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setUserId(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_invalid_userId() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setUserId(-35L);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_missing_timePlaced() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setTimePlaced(null);

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	@Test(expected = LindacareInvalidParameterException.class)
	public void should_return_exception_invalid_timePlaced_inFuture() throws Exception {
		MarketMessage marketMessage = createDefaultMarketMessage();
		marketMessage.setTimePlaced(LocalDateTime.now().plusHours(1));

		marketMessage = marketMessageService.createMarketMessage(marketMessage);
	}

	private MarketMessage createDefaultMarketMessage() {
		MarketMessage marketMessageSaved = new MarketMessage();
		marketMessageSaved.setAmountBuy(new BigDecimal("15.15"));
		marketMessageSaved.setAmountSell(new BigDecimal("10.00"));
		marketMessageSaved.setRate(new BigDecimal("0.7471"));
		marketMessageSaved.setOriginatingCountry(new String("FR"));
		marketMessageSaved.setCurrencyFrom(Currency.getInstance("EUR"));
		marketMessageSaved.setCurrencyTo(Currency.getInstance("GBP"));
		marketMessageSaved.setTimePlaced(LocalDateTime.now().withNano(0));
		marketMessageSaved.setUserId(134256L);

		return marketMessageSaved;
	}
}
