package com.eureka.utils;

import com.eureka.vo.CacheVO;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LocalCache {

	private static Cache<String, CacheVO> cache =
			CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(1, TimeUnit.DAYS).build();

	private static Cache<String, Map<String, String>> secret =
			CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(1, TimeUnit.DAYS).build();

	public static CacheVO getLevel(String from) {
		CacheVO cacheDTO = null;
		if (StringUtils.isNotEmpty(from)) {
			cacheDTO = cache.getIfPresent(from);
			if (cacheDTO == null) {
				return null;
			}
		}
		return cacheDTO;
	}

	public static Map<String, String> getSecretCode(String from) {
		Map<String, String> map = null;
		if (StringUtils.isNotEmpty(from)) {
			map = secret.getIfPresent(from);
			if (map == null) {
				return null;
			}
		}
		return map;
	}

	public static void putLevel(CacheVO cacheDTO) {
		cache.put(cacheDTO.getChannelId(), cacheDTO);
	}

	public static void flushAllCache() {
		cache.invalidateAll();
	}

}
