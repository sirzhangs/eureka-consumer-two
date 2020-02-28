package com.sirzhangs.consumer.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.consumer.entity.User;
/**
 * Ribbon方式 远程调用，并开启熔断
 * @author sirzh
 *
 */
@Component
public class UserFeign {
	
	private final static String HOST_URL = "http://EUREKA-PROVIDER-ONE";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "addUser")
	public RequestResult add(User user) {
		return restTemplate.getForObject(HOST_URL+"/user/manage/add", RequestResult.class,user);
	};
	
	@HystrixCommand(fallbackMethod = "findUserById")
	public RequestResult findById(String id) {
		return restTemplate.getForObject(HOST_URL+"/user/manage/findById/{id}", RequestResult.class,id);
	};
	
	public RequestResult addUser(User user) {
		return RequestResult.fail("addUser采用Robbin熔断");
	};
	
	public RequestResult findUserById(String id) {
		return RequestResult.fail("findUserById采用Robbin熔断");
	};

}
