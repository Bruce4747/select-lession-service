package com.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: eddie
 * @Date: 2018-09-19
 */
@FeignClient(name="service-ribbon")
public interface ConsumerController {

	@PostMapping(value = "/registerTeacher")
	String hello(@RequestParam(value = "name") String name);
}
