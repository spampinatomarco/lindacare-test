package com.spdev.lindacaretest.utils.converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 
 * @author marco
 *
 */
@Component
public class JsonLocalDateTimeDeSerializer extends JsonDeserializer<LocalDateTime> {
	private static final DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yy HH:mm:ss").toFormatter(Locale.ENGLISH);

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return LocalDateTime.parse(p.getValueAsString(), dateFormat);
	}

}