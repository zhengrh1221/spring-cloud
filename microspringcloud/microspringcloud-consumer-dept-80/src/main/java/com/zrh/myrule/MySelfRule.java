package com.zrh.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		//return new RandomRule();//默认是轮询，自定义为随机
		return new RoundRobinRule();//默认是轮询，自定义为随机
	}
}
