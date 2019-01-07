package com.sharma.productservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_master")
public class Product {

	@Id
	private String id;
	private String name;
	private String number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

	public Product(String id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
