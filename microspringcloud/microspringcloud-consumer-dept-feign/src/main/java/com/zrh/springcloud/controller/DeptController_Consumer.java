package com.zrh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zrh.springcloud.entities.Dept;
import com.zrh.springcloud.service.DeptClientServiceMS;

@RestController
public class DeptController_Consumer {

	@Autowired
	private DeptClientServiceMS deptService;
	
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {

		return this.deptService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {

		return this.deptService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {

		return this.deptService.list();
	}

}
