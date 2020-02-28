package com.sirzhangs.consumer.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Ribbon restFul及负载均衡
 * @author sirzh
 *
 */
@Configuration
public class RestTemplateConfigure {

	@Bean	//向IOC容器注册实例
	@LoadBalanced	//开启负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
