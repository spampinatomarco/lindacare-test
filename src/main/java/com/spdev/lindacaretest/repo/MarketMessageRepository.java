package com.spdev.lindacaretest.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spdev.lindacaretest.model.MarketMessage;

/**
 * Repository for the model MarketMessage.
 * 
 * @author marco
 *
 */
@Repository
public interface MarketMessageRepository extends MongoRepository<MarketMessage, Long> {

	public MarketMessage getById(Long id);

	public Page<MarketMessage> findAll(Pageable pageable);

}
