package com.eureka.controller;

import com.eureka.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
;
@RestController
public class UserManagerController {

	@Autowired
	private ServiceProvider serviceProvider;

	@GetMapping(value = "/hello/say")
	public String sayHello(){
		return serviceProvider.getList();
	}

}
