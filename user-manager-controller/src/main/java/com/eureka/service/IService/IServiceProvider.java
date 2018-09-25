package com.eureka.service.IService;

import com.eureka.dto.Response;

public interface IServiceProvider {

	Response registerStudent(String param);

	Response registerTeacher(String param);

	Response login(String param);

	Response Error(String res);
}
