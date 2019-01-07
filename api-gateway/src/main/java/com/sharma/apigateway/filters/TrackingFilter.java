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
public class TrackingFilter extends ZuulFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;

	private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	@Override
	public Object run() throws ZuulException {

		if (isCorrelationIdPresent()) {
			logger.info("tmx-correlation-id found in tracking filter: " + filterUtils.getCorrelationId());
		} else {
			filterUtils.setCorrelationId(generateCorrelationId());
			logger.info("tmx-correlation-id generated in tracking filter: " + filterUtils.getCorrelationId());
		}
		RequestContext requestContext = RequestContext.getCurrentContext();
		logger.info("Processing incoming request for : " + requestContext.getRequest().getRequestURI());
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
		return FilterUtils.PRE_FILTER_TYPE;
	}

	private boolean isCorrelationIdPresent() {
		if (filterUtils.getCorrelationId() != null) {
			return true;
		} else {
			return false;
		}
	}

	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}

}
