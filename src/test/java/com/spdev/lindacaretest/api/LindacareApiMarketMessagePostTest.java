package com.spdev.lindacaretest.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import com.google.gson.Gson;
import com.spdev.lindacaretest.api.dto.request.ApiMarketMessagePostRequest;

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

	private Gson gson = new Gson();

	@Before
	public void setup() {
	}

	@Test
	public void should_PostMarketMessage() throws Exception {
		ApiMarketMessagePostRequest request = new ApiMarketMessagePostRequest();

		String json = gson.toJson(request);

		MockHttpServletRequestBuilder content = post(LindacareApi.MESSAGES_PATH).contentType(MediaType.APPLICATION_JSON_VALUE).content(json);

		ResultActions resultActions = mvc.perform(content);

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

		// validateResultContentAccessDevice(request, resultActions);

	}
}
