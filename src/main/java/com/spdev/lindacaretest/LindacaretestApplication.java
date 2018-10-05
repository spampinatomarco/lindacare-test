package com.spdev.lindacaretest;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.joda.time.DateTimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author marco
 *
 */
@SpringBootApplication
public class LindacaretestApplication {

	@PostConstruct
	public void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		DateTimeZone.setDefault(DateTimeZone.UTC);
	}

	public static void main(String[] args) {
		SpringApplication.run(LindacaretestApplication.class, args);
	}
}
