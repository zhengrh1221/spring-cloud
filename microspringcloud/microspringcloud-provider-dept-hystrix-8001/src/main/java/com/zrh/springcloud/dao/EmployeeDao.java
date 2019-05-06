package com.zrh.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zrh.springcloud.entities.Employee;

@Mapper
public interface EmployeeDao {

	
	public Boolean add(Employee employee);
	
	
	public Employee findById(Long empId);
	
	
	public List<Employee> findAll();
	
}
