package com.colodoo.framework.security;

import com.colodoo.framework.security.interceptor.LogInterceptor;
import com.colodoo.framework.security.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
	/**
	 * 日志拦截器
	 */
	@Autowired
	private LogInterceptor logInterceptor;
	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	/**
	 * 重写添加拦截器方法并添加配置拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor);
		// registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/loginCheck").excludePathPatterns("/user/logout");
	}
}
