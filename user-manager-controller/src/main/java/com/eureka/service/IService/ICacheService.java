package com.eureka.service.IService;

import com.eureka.vo.CacheVO;

import java.util.Map;

public interface ICacheService {

	CacheVO isCanUse(String from);

	Map<String, String> secretMap(String param);

	void flushCache();
}
