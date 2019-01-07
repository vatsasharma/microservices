package com.sharma.helloservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.helloservice.model.Employee;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	@RequestMapping(value = "employee-details/{id}/{name}/{age}")
	public Employee helloEmployee(@PathVariable("id") String id, @PathVariable("name") String name,
			@PathVariable("age") int age) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAge(age);
		return employee;

	}
}
