package com.eureka.controller;

import com.eureka.service.ConsumerController;
import com.eureka.vo.CacheVO;
import com.eureka.dto.Response;
import com.eureka.dto.UserRequest;
import com.eureka.service.IService.ICacheService;
import com.eureka.service.IService.IServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserManagerController {

	@Autowired
	private IServiceProvider serviceProvider;

	@Autowired
	private ICacheService cacheService;

	@Autowired
	private ConsumerController consumerController;

	/**
	 * 对外接口层入口，提供访问权限
	 * @param route
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/user/{route}")
	public Response registerStudent(@PathVariable("route") String route, UserRequest request){
		CacheVO cacheVO = cacheService.isCanUse(request.getFrom());
		if (!Objects.isNull(cacheVO)) {
			int level = cacheVO.getLevel();
			if (level < 3) {
				return new Response(cacheVO);
			}
		}

		switch (route){
			case "registerStudent":
				return serviceProvider.registerStudent(request.getFrom());
			case "registerTeacher":
				return serviceProvider.registerTeacher(request.getFrom());
			case "login":
				return serviceProvider.login(request.getFrom());
			default:
				return Response.SYS_UNOPENED_IDENTIFY;
		}
	}

	@GetMapping(value = "/test")
	public String test(){
		return consumerController.hello("");
	}

}