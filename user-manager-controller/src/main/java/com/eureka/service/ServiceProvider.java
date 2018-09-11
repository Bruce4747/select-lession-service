package com.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceProvider {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "Error")
	public String getList() {
		return restTemplate.getForObject("http://SERVICE-RIBBON/start",String.class);
	}

	public String Error() {
		return "sorry,server error!";
	}
}
