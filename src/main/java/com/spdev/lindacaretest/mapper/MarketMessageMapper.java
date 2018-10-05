package com.spdev.lindacaretest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.spdev.lindacaretest.api.dto.ApiMarketMessage;
import com.spdev.lindacaretest.model.MarketMessage;

/**
 * Mapper for the MarketMessage entity
 * 
 * @author marco
 *
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MarketMessageMapper {

	ApiMarketMessage to(MarketMessage marketMessage);

	MarketMessage from(ApiMarketMessage ecu);
}
