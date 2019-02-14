package com.colodoo.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.colodoo.framework.common.SessionObject;

//@Configuration
public class CustomBeansConf {
	
	@Bean
	@SessionScope
	public SessionObject sessionObject() {
		return new SessionObject();
	}

}
