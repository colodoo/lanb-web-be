package com.colodoo.framework.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {
	@SuppressWarnings("rawtypes")
	@Bean
	public WebServerFactoryCustomizer containerCustomizer() {
		return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

			@Override
			public void customize(ConfigurableWebServerFactory factory) {
				ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
				factory.addErrorPages(error400Page, error404Page, error500Page);
			}
		};
	}

}
