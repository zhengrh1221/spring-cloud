package com.zrh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient //本服务启动后会自动注册到eureka中
public class DeptProvider8001_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_App.class, args);

	}

}
