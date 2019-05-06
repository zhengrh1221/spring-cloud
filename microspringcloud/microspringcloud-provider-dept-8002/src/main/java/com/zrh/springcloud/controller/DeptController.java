package com.zrh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zrh.springcloud.entities.Dept;
import com.zrh.springcloud.service.DeptService;

@RestController
@RequestMapping(value="/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient client;

	@PostMapping(value = "/add")
	public boolean add(@RequestBody Dept dept) {

		return deptService.add(dept);
	}

	@GetMapping(value = "/get/{id}")
	public Dept get(@PathVariable("id") Long id) {

		return deptService.get(id);
	}

	@GetMapping(value = "/list")
	public List<Dept> findAll() {

		return deptService.list();
	}

	@GetMapping(value="/discovery")
	public Object discovery() {

		List<String> list = client.getServices();
		System.out.println("********" + list);

		List<ServiceInstance> servList = client.getInstances("MICROSERVICECLOUD-DEPT");

		for (ServiceInstance element : servList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}

		return this.client;
	}

}
