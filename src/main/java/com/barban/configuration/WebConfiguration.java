package com.barban.configuration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Configuration
public class WebConfiguration {
	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	@Bean
	public Filter loggingFilter() {
		AbstractRequestLoggingFilter f = new AbstractRequestLoggingFilter() {

			@Override
			protected void beforeRequest(HttpServletRequest request, String message) {
				System.out.println(message);
			}

			@Override
			protected void afterRequest(HttpServletRequest request, String message) {
				System.out.println(message);
			}
		};
		f.setIncludeClientInfo(true);
		f.setIncludePayload(true);
		f.setIncludeQueryString(true);

		f.setBeforeMessagePrefix("BEFORE REQUEST  [");
		f.setAfterMessagePrefix("AFTER REQUEST    [");
		f.setAfterMessageSuffix("]\n");
		return f;
	}
}