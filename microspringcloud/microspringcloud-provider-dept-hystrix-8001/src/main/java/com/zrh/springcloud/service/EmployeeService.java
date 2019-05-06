package com.zrh.springcloud.service;

import java.util.List;

import com.zrh.springcloud.entities.Employee;

public interface EmployeeService {
	
	public Boolean add(Employee employee);
	
	
	public Employee findById(Long empId);
	
	
	public List<Employee> findAll();

}
