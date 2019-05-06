package com.zrh.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zrh.springcloud.entities.Employee;

@FeignClient("MICROSERVICECLOUD-DEPT")
public interface EmployeeClientServiceMS {
	
	@RequestMapping(value="/employee/add",method=RequestMethod.POST)
	public Boolean add(Employee employee);

	@RequestMapping(value="/employee/get/{id}",method=RequestMethod.GET)
	public Employee get(@PathVariable("id")Long id);

	@RequestMapping(value="/employee/list",method=RequestMethod.GET)
	public List<Employee> list(); 

}
