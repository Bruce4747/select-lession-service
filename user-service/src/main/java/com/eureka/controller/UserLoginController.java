package com.eureka.controller;

import com.eureka.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

	@Autowired
	private UserManagerService userManagerService;

	@GetMapping("/start")
	public String getList(){
		return "";
	}
}
