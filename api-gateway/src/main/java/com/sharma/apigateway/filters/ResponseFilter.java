package com.sharma.apigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sharma.apigateway.utils.FilterUtils;

@Component
public class ResponseFilter extends ZuulFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;

	private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		logger.info("Adding the correlation id to the outbound headers. {}", filterUtils.getCorrelationId());
		context.getResponse().addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());
		logger.info("Completing outgoing request : " + context.getRequest().getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

	@Override
	public String filterType() {
		return filterUtils.POST_FILTER_TYPE;
	}

}
