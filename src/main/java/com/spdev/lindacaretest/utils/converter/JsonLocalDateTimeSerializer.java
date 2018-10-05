package com.spdev.lindacaretest.utils.converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @author marco
 *
 */
@Component
public class JsonLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
	private static final DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd-MMM-yy HH:mm:ss").toFormatter(Locale.ENGLISH);

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(date);
		gen.writeString(formattedDate.toUpperCase());
	}

}