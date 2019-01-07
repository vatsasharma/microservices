package com.sharma.productservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sharma.productservice.model.Customer;

@Component
public class CustomerRestTemplateClient {

	@Autowired
	private RestTemplate restTemplate;

	public Customer getCustomer(String customerId) {
		ResponseEntity<Customer> restExchange = restTemplate.exchange(
				"http://customer-service/customer/customer-details/{customerId}", HttpMethod.GET, null, Customer.class,
				customerId);
		return restExchange.getBody();
	}

}
