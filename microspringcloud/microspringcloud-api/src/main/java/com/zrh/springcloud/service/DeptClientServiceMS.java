package com.zrh.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zrh.springcloud.entities.Dept;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientServiceMS {

	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public Boolean add(Dept dept);

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id")Long id);

	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list();

}
