package com.barban.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
				.antMatchers("/console/**").permitAll();

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		;
	}

}

/*
 * Driver Class org.h2.Driver 
 * JDBC URL jdbc:h2:mem:testdb 
 * User Name sa 
 * Password
 */