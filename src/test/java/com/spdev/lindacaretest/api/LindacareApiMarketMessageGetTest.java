package com.spdev.lindacaretest.api;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.model.MarketMessage;
import com.spdev.lindacaretest.repo.MarketMessageRepository;
import com.spdev.lindacaretest.utils.IDUtil;

/**
 * Test for the Api post MarketMessage
 * 
 * @author marco
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LindacareApiMarketMessageGetTest {

	private static final int MARKET_MESSAGE_TO_CREATE = 500;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MarketMessageRepository marketMessageRepository;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		marketMessageRepository.deleteAll();
		for (int i = 0; i < MARKET_MESSAGE_TO_CREATE; i++) {
			MarketMessage marketMessageSaved = new MarketMessage();
			marketMessageSaved.setAmountBuy(new BigDecimal("15.15"));
			marketMessageSaved.setAmountSell(new BigDecimal("10.00"));
			marketMessageSaved.setRate(new BigDecimal("0.7471"));
			marketMessageSaved.setOriginatingCountry(new String("FR"));
			marketMessageSaved.setCurrencyFrom(Currency.getInstance("EUR"));
			marketMessageSaved.setCurrencyTo(Currency.getInstance("GBP"));
			marketMessageSaved.setTimePlaced(LocalDateTime.now().withNano(0));
			marketMessageSaved.setUserId(IDUtil.getUniqueId());
			marketMessageSaved.setId(IDUtil.getUniqueId());
			marketMessageRepository.save(marketMessageSaved);
		}
	}

	@Test
	public void should_getMarketMessage_with_pagination() throws Exception {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put("page", "0");
		requestParams.put("size", "10");

		String url = requestParams.keySet().stream().map(key -> key + "=" + requestParams.get(key)).collect(Collectors.joining("&", LindacareApi.MESSAGES_PATH + "?", ""));

		MockHttpServletRequestBuilder requestBuilder = get(url);
		requestBuilder.contentType(MediaType.APPLICATION_JSON);

		ResultActions resultActions = this.mvc.perform(requestBuilder);
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.marketMessages.size", is(10)));
		resultActions.andExpect(jsonPath("$.marketMessages.number", is(0)));
		resultActions.andExpect(jsonPath("$.marketMessages.totalElements", is(MARKET_MESSAGE_TO_CREATE)));
	}

	@Test
	public void should_return400_invalid_size() throws Exception {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put("page", "0");
		requestParams.put("size", String.valueOf(LindacareApi.MAX_PAGE_SIZE + 1));

		String url = requestParams.keySet().stream().map(key -> key + "=" + requestParams.get(key)).collect(Collectors.joining("&", LindacareApi.MESSAGES_PATH + "?", ""));

		MockHttpServletRequestBuilder requestBuilder = get(url);
		requestBuilder.contentType(MediaType.APPLICATION_JSON);

		ResultActions resultActions = this.mvc.perform(requestBuilder);
		resultActions.andExpect(status().is4xxClientError());
	}

}
