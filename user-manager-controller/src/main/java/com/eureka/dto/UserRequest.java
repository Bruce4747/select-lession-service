package com.eureka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserRequest {

	private String sign;

	private String from;

	private String param;

	private Date date;

}
