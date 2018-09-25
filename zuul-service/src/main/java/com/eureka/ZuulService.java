package com.eureka;

import com.eureka.filters.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@SpringCloudApplication
public class ZuulService {

	public static void main(String args[]) {
		SpringApplication.run(ZuulService.class, args);
	}

	@Bean
	public TestFilter testPreFilter(){
		return new TestFilter();
	}

}
