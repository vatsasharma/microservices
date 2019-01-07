package com.sharma.customerservice.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserContextFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		// Set Correlation Id in User Context
		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATON_ID));

		// Set User Id in User Context
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));

		// Set Auth Token in User Context
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));

		// Set Org Id in User Context
		UserContextHolder.getContext().setOrgId(httpServletRequest.getHeader(UserContext.ORG_ID));

		filterChain.doFilter(httpServletRequest, servletResponse);

	}

}
