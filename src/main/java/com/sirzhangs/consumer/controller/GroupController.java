package com.sirzhangs.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.consumer.entity.User;
import com.sirzhangs.consumer.remote.UserFeign;

@RestController
@RequestMapping("/group/manage")
public class GroupController {
	
	@Autowired
	private UserFeign userFeign;
	
	@PostMapping("add")
	public RequestResult add(
			@RequestBody User user
			) {
		return userFeign.add(user);
	}
	
	@GetMapping("/findById/{id}")
	public RequestResult findById(
			@PathVariable("id")String id) {
		return userFeign.findById(id);
	}

}
