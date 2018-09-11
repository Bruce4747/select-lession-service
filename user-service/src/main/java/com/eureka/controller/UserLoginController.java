package com.eureka.controller;

import com.eureka.dto.Response;
import com.eureka.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

	@Autowired
	private UserManagerService userManagerService;

	@PostMapping("/registerTeacher")
	public Response registerTeacher(String schoolID, String teacherName, String userPassword, String userPhone,String researchArea){
		return userManagerService.registerTeacher(schoolID, teacherName, userPassword, userPhone, researchArea);
	}

	@PostMapping("/registerStudent")
	public Response registerStudent(String schoolID, String studentName, String userPassword, String userPhone, String schoolClass){
		return userManagerService.registerStudent(schoolID, studentName, userPassword, userPhone, schoolClass);
	}
}
