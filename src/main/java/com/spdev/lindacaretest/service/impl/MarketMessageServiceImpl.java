package com.spdev.lindacaretest.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spdev.lindacaretest.exception.LindacareInvalidParameterException;
import com.spdev.lindacaretest.model.MarketMessage;
import com.spdev.lindacaretest.repo.MarketMessageRepository;
import com.spdev.lindacaretest.service.MarketMessageService;
import com.spdev.lindacaretest.service.UserService;
import com.spdev.lindacaretest.utils.IDUtil;
import com.spdev.lindacaretest.utils.ReflectionUtils;

/**
 * 
 * @author marco
 *
 */
@Service
public class MarketMessageServiceImpl implements MarketMessageService {

	@Autowired
	private UserService userService;

	@Autowired
	private MarketMessageRepository marketMessageRepository;

	@Override
	public MarketMessage createMarketMessage(MarketMessage marketMessage) {
		Assert.notNull(marketMessage, "The marketMessage should be not null");

		marketMessage.setId(IDUtil.getUniqueId());

		validateMarketMessage(marketMessage);

		return marketMessageRepository.save(marketMessage);
	}

	private void validateMarketMessage(MarketMessage marketMessage) {
		ReflectionUtils.trimAllStringParameter(marketMessage);

		BigDecimal amountBuy = marketMessage.getAmountBuy();
		if (amountBuy == null || !(amountBuy.compareTo(BigDecimal.ZERO) > 0)) {
			throw new LindacareInvalidParameterException("The amountBuy cannot be null or <=0");
		}

		BigDecimal amountSell = marketMessage.getAmountSell();
		if (amountSell == null || !(amountSell.compareTo(BigDecimal.ZERO) > 0)) {
			throw new LindacareInvalidParameterException("The amountSell cannot be null or <=0");
		}

		BigDecimal rate = marketMessage.getRate();
		if (rate == null) {
			throw new LindacareInvalidParameterException("The rate cannot be null");
		}

		if (marketMessage.getCurrencyFrom() == null) {
			throw new LindacareInvalidParameterException("The currencyFrom cannot be null");
		}

		if (marketMessage.getCurrencyTo() == null) {
			throw new LindacareInvalidParameterException("The currencyTo cannot be null");
		}

		if (marketMessage.getOriginatingCountry() == null) {
			throw new LindacareInvalidParameterException("The originatingCountry To cannot be null");
		}

		if (marketMessage.getTimePlaced() == null) {
			throw new LindacareInvalidParameterException("The timePlaced cannot be null");
		}

		if (marketMessage.getTimePlaced().isAfter(LocalDateTime.now())) {
			throw new LindacareInvalidParameterException("The timePlaced cannot be in the future");
		}

		// check if the user exist also (fake)
		Long userId = marketMessage.getUserId();
		if (!userService.isUserExist(userId)) {
			throw new LindacareInvalidParameterException(String.format("The user with the id :d doesn't exist", userId));
		}

	}
}