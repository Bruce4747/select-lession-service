package com.eureka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.eureka.dto")
public class ServiceApplication {

	public static void main(String args[]){
		SpringApplication.run(ServiceApplication.class,args);
	}

}