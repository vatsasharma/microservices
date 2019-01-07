package com.sharma.productservice.service;

import java.util.List;

import com.sharma.productservice.model.Customer;
import com.sharma.productservice.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Customer getCustomer(String customerId, String client);

	Customer getCustomerUsingFeignClient(String customerId);
}
