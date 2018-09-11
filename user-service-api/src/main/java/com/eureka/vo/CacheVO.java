package com.eureka.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CacheVO {

	private String channelId;

	private int level;

	private String token;

	private Date startTime;

	private Date endTime;

	public CacheVO() {}

	public CacheVO(String channelId, int level, String token, Date startTime, Date endTime) {
		this.channelId = channelId;
		this.level = level;
		this.token = token;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public CacheVO(String channelId, int level) {
		this.channelId = channelId;
		this.level = level;
	}
}
