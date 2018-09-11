package com.eureka.dao;

import com.eureka.vo.CacheVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChannelDAO {

	@Select("SELECT CHANNEL_ID AS channelId,LEVEL AS level,TOKEN AS token,START_TIME AS startTime,END_TIME AS endTime FROM T_CHANNEL_LEVEL WHERE CHANNEL_ID=#{channel}")
	CacheVO getChannelLevel(@Param("channel") String channel);
}
