package com.spdev.lindacaretest.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import org.junit.Assert;
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
import com.spdev.lindacaretest.api.dto.ApiMarketMessage;
import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;
import com.spdev.lindacaretest.api.dto.response.ApiMarketMessagePostResponse;

/**
 * Test for the Api post MarketMessage
 * 
 * @author marco
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LindacareApiMarketMessagePostTest {

	@Autowired
	private MockMvc mvc;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
	}

	@Test
	public void should_PostMarketMessage() throws Exception {
		ApiMarketMessagePostRequest request = createDefaultRequest();
		String json = objectMapper.writeValueAsString(request);

		MockHttpServletRequestBuilder content = post(LindacareApi.MESSAGES_PATH).contentType(MediaType.APPLICATION_JSON_VALUE).content(json);

		ResultActions resultActions = mvc.perform(content);

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

		validateResult(request, resultActions);

	}

	@Test
	public void should_WithStaticValue_PostMarketMessage() throws Exception {
		String json = "{\"userId\": \"134256\", \"currencyFrom\": \"EUR\", \"currencyTo\": \"GBP\", \"amountSell\": 1000,\"amountBuy\": 747.10, \"rate\": 0.7471, \"timePlaced\" : \"24-JAN-15 10:27:44\", \"originatingCountry\": \"FR\"}";

		MockHttpServletRequestBuilder content = post(LindacareApi.MESSAGES_PATH).contentType(MediaType.APPLICATION_JSON_VALUE).content(json);

		ResultActions resultActions = mvc.perform(content);

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

		ApiMarketMessagePostRequest request = objectMapper.readValue(json, ApiMarketMessagePostRequest.class);
		validateResult(request, resultActions);

	}

	@Test
	public void should_returnStatus400_InvalidJsonFormat() throws Exception {
		String json = "{\"userId\": \"134256\", \"currencyFrom\": \"EUR\", \"currencyTo\": \"GBP\", \"amountSell\": 1000,\"amountBuy\": 747.10, \"rate\": 0.7471, \"timePlaced\" : \"2-JAN-15 10:27:44\", \"originatingCountry\": \"FR\"}";

		MockHttpServletRequestBuilder content = post(LindacareApi.MESSAGES_PATH).contentType(MediaType.APPLICATION_JSON_VALUE).content(json);

		ResultActions resultActions = mvc.perform(content);

		resultActions.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

	private ApiMarketMessagePostRequest createDefaultRequest() {
		ApiMarketMessagePostRequest request = new ApiMarketMessagePostRequest();
		request.setAmountBuy(new BigDecimal("15.15"));
		request.setAmountSell(new BigDecimal("10.00"));
		request.setRate(new BigDecimal("0.7471"));
		request.setOriginatingCountry(new String("FR"));
		request.setCurrencyFrom(Currency.getInstance("EUR"));
		request.setCurrencyTo(Currency.getInstance("GBP"));
		request.setTimePlaced(LocalDateTime.now().withNano(0));
		request.setUserId(134256L);

		return request;
	}

	private void validateResult(ApiMarketMessagePostRequest request, ResultActions resultActions) throws Exception {

		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());

		String response = resultActions.andReturn().getResponse().getContentAsString();
		ApiMarketMessagePostResponse apiResponse = objectMapper.readValue(response, ApiMarketMessagePostResponse.class);

		ApiMarketMessage marketMessage = apiResponse.getMarketMessage();

		Assert.assertNotNull(marketMessage.getId());
		Assert.assertThat(marketMessage.getUserId(), is(request.getUserId()));
		Assert.assertThat(marketMessage.getAmountBuy(), is(request.getAmountBuy()));
		Assert.assertThat(marketMessage.getAmountSell(), is(request.getAmountSell()));
		Assert.assertThat(marketMessage.getRate(), is(request.getRate()));
		Assert.assertThat(marketMessage.getCurrencyFrom(), is(request.getCurrencyFrom()));
		Assert.assertThat(marketMessage.getCurrencyTo(), is(request.getCurrencyTo()));
		Assert.assertThat(marketMessage.getTimePlaced(), is(request.getTimePlaced()));
		Assert.assertThat(marketMessage.getOriginatingCountry(), is(request.getOriginatingCountry()));

	}
}
