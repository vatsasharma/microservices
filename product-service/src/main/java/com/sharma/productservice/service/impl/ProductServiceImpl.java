package com.sharma.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.productservice.clients.CustomerDiscoveryClient;
import com.sharma.productservice.clients.CustomerFeignClient;
import com.sharma.productservice.model.Customer;
import com.sharma.productservice.model.Product;
import com.sharma.productservice.repository.ProductRepository;
import com.sharma.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerDiscoveryClient customerDiscoveryClient;

	@Autowired
	private CustomerFeignClient customerFeignClient;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Customer getCustomer(String customerId, String client) {
		return customerDiscoveryClient.getCustomer(customerId);
	}

	@Override
	public Customer getCustomerUsingFeignClient(String customerId) {
		return customerFeignClient.getCustomer(customerId);
	}

}
