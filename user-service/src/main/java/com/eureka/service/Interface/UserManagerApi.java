package com.eureka.service.Interface;

import com.eureka.dto.Response;

public interface UserManagerApi {

	Response registerTeacher(String schoolID, String teacherName, String userPassword, String userPhone, String researchArea);

	Response registerStudent(String schoolID, String studentName, String userPassword, String userPhone, String schoolClass);

	Response login(String userLevel, String id, String userPassword);

}
