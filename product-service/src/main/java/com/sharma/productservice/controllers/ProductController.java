package com.sharma.productservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sharma.productservice.clients.CustomerRestTemplateClient;
import com.sharma.productservice.model.Customer;
import com.sharma.productservice.model.Product;
import com.sharma.productservice.service.ProductService;

@RestController
@RequestMapping(value = "product-details")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerRestTemplateClient customerRestTemplateClient;

	@RequestMapping
	public String helloProduct() {
		return "Hello Product";
	}

	@HystrixCommand
	@RequestMapping(value = "/list-all-products")
	public List<Product> listAllProducts() {
		logger.info("Product Controller : {}/list-all-products");
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/get-customer/{id}/{client}")
	public Customer getCustomer(@PathVariable("id") String customerId, @PathVariable("client") String client) {
		return productService.getCustomer(customerId, client);
	}

	@RequestMapping(value = "/customer/{id}")
	public Customer getCustomerUsingRestTemplateClient(@PathVariable("id") String customerId) {
		return customerRestTemplateClient.getCustomer(customerId);
	}

	@RequestMapping(value = "/customer/{id}/{client}")
	public Customer getCustomerUsingFeignClient(@PathVariable("id") String customerId,
			@PathVariable("client") String client) {
		return productService.getCustomerUsingFeignClient(customerId);
	}

}
