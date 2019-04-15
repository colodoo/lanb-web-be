package com.colodoo.framework.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SecurityRequestWrapper extends HttpServletRequestWrapper {

	public SecurityRequestWrapper(HttpServletRequest request) {
		super(request);
	}

}
