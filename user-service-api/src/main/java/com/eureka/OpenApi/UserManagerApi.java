package com.eureka.OpenApi;

import com.eureka.dto.Response;

public interface UserManagerApi {

	Response register(String schoolID, String teacherName, String userPassword, String userPhone, String researchArea);

	Response login(String userLevel, String id, String userPassword);

}
