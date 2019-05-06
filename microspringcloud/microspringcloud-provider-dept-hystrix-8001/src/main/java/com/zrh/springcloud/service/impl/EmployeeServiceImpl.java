package com.zrh.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrh.springcloud.dao.EmployeeDao;
import com.zrh.springcloud.entities.Employee;
import com.zrh.springcloud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Boolean add(Employee employee) {
		return dao.add(employee);
	}

	@Override
	public Employee findById(Long empId) {
		return dao.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

}
