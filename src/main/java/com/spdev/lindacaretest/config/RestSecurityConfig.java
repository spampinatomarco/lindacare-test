package com.spdev.lindacaretest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Rest security configuration
 * 
 * @author marco
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class RestSecurityConfig {

	@Configuration
	public static class RestEndpointConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// Don't want to handle the crsf security in the case of this test
			http = http.csrf().disable();
			http = http.httpBasic().disable();
		}
	}
}