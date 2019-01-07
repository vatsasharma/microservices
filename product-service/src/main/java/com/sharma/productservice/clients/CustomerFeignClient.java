package com.sharma.productservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sharma.productservice.model.Customer;

@FeignClient("customer-service")
public interface CustomerFeignClient {

	@RequestMapping(value = "/customer/customer-details/{customerId}", method = RequestMethod.GET, consumes = "application/json")
	Customer getCustomer(@PathVariable("customerId") String customerId);
}
