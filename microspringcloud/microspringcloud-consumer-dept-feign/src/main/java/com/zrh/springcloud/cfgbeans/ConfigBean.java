package com.zrh.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {// boot ->> spring application.xml ---@Configuration配置
							// Configuration=application.xml

	@Bean
	@LoadBalanced //客户端的负载均衡
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		
		//return new RandomRule();//达到目的，用我们重新选择的随机算法替代默认的轮询
		return new RandomRule();
	}
}
