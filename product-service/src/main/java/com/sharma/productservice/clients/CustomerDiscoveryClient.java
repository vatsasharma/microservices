package com.sharma.productservice.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sharma.productservice.model.Customer;

@Component
public class CustomerDiscoveryClient {

	@Autowired
	private DiscoveryClient discoveryClient;

	public Customer getCustomer(String customerId) {
		RestTemplate restTemplate = new RestTemplate();

		List<ServiceInstance> instances = discoveryClient.getInstances("customer-service");
		if (instances.size() == 0)
			return null;

		String serviceUri = String.format("%s/customer/customer-details/%s", instances.get(0).getUri().toString(),null);
		System.out.println("Service URI :"+serviceUri);
		ResponseEntity<Customer> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Customer.class,customerId);
		return restExchange.getBody();

	}

}
