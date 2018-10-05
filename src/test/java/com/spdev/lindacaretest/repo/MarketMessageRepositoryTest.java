package com.spdev.lindacaretest.repo;

import static org.hamcrest.CoreMatchers.is;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spdev.lindacaretest.exception.LindacareInvalidParameterException;
import com.spdev.lindacaretest.model.MarketMessage;
import com.spdev.lindacaretest.utils.IDUtil;

/**
 * Test for the MarketMessageRepository
 * 
 * @author marco
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketMessageRepositoryTest {

	@Autowired
	private MarketMessageRepository marketMessageRepository;

	@Test
	public void should_findMarketMessage_byId() throws Exception {

		MarketMessage marketMessageToSave = new MarketMessage();
		marketMessageToSave.setId(IDUtil.getUniqueId());
		marketMessageToSave = marketMessageRepository.save(marketMessageToSave);

		MarketMessage marketMessageFind = marketMessageRepository.getById(marketMessageToSave.getId());

		Assert.assertThat(marketMessageToSave, is(marketMessageFind));
		Assert.assertThat(marketMessageToSave.getId(), is(marketMessageFind.getId()));
	}

	@Test
	public void should_notFindMarketMessage_byId() throws Exception {

		MarketMessage marketMessageFind = marketMessageRepository.getById(1L);
		Assert.assertNull(marketMessageFind);
	}
}
