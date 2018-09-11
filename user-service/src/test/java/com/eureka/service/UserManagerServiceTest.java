package com.eureka.service;

import com.eureka.dto.Response;
import com.eureka.util.CommonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserManagerServiceTest {

	@Autowired
	private UserManagerService userManagerService;

	@Test
	public void md5Str() {
		String lnfvc = CommonUtil.generateTeacherId("LNFVC");
		System.out.println(lnfvc);
	}

	@Test
	public void registerTeacher() {
		Response response = userManagerService.registerTeacher("LNFVC", "李映时", "776543", "18640026006", "软件开发");
		System.out.println(response);
	}

	@Test
	public void registerStudent() {
		Response response = userManagerService.registerStudent("LNFVC", "李映时", "776543", "18640026006", "17软件开发");
		System.out.println(response);
	}

	@Test
	public void login() {
		Response response = userManagerService.login("TEACHER_LOGIN", "LNFVC2018959954", "776543");
		System.out.println(response);
	}
}