package com.zrh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zrh.springcloud.entities.Dept;
import com.zrh.springcloud.service.DeptService;

@RestController
@RequestMapping(value = "/dept")
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
	// 一旦调用服务方法失败并抛出了错误信息后，会自动调用@@HystrixCommand标注好的fallbackMethod调用类中的制定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {

		Dept dept = deptService.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID" + id + "没有对应的信息");
		}

		return deptService.get(id);
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {

		return new Dept().setDeptno(id).setDname("该ID" + id + "没有对应的信息,null--@@HystrixCommand");
	}

	@GetMapping(value = "/list")
	public List<Dept> findAll() {

		return deptService.list();
	}

	@GetMapping(value = "/discovery")
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
	
	
	//@Scheduled(cron="0 0/2 * * * ?")
	public void scheduleTest() {
		
		for (int i = 0; i < 10; i++) {
			System.err.println("scheduleTest:"+i);
		}
		
		
	}

}
