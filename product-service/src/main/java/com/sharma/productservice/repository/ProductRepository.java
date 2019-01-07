package com.sharma.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sharma.productservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
