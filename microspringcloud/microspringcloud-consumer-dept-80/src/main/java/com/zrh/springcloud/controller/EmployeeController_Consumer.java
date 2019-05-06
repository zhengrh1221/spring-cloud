package com.zrh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zrh.springcloud.entities.Employee;
import com.zrh.springcloud.service.EmployeeClientServiceMS;

@RestController
@RequestMapping(value = "/consumer")
public class EmployeeController_Consumer {

	@Autowired
	public EmployeeClientServiceMS serviceMS;

	@PostMapping(value = "/add")
	public boolean add(Employee employee) {

		return serviceMS.add(employee);
	}

	@GetMapping(value = "/list")
	public List<Employee> list() {

		return serviceMS.list();
	}

	@GetMapping(value = "/get/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		return findById(id);
	}

}
