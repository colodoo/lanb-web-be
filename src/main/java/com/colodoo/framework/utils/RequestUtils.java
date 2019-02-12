package com.colodoo.framework.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	/**
	 * 取客户端用户IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddress(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

}
