package com.zrh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //Hystrix熔断处理
@EnableEurekaClient //本服务启动后会自动注册到eureka中
//@EnableScheduling
public class DeptProvider8001_Hystrix_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);

	}

}
