package com.sharma.customerservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sharma.customerservice.model.Customer;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

	@HystrixCommand
	@RequestMapping(value = "customer-details/{customerId}")
	public Customer getCustomerDetails(@PathVariable("customerId") String customerId) {
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setName("CUSTOMER_1");
		customer.setPhoneNumber("+908933333333");
		return customer;

	}

}
