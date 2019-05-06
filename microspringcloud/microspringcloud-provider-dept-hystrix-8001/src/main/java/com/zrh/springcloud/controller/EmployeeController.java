package com.zrh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zrh.springcloud.entities.Employee;
import com.zrh.springcloud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@GetMapping(value="/get/{id}")
	public Employee findById(@PathVariable("id")Long id) {
		return this.service.findById(id);
		
	}
	
	
	@GetMapping(value="/list")
	public List<Employee> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping(value="/add")
	public Boolean add(@RequestBody Employee employee) {
		return this.add(employee);
	}
	
}
