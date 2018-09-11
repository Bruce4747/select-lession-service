package com.eureka.service;

import com.eureka.vo.CacheVO;
import com.eureka.dao.ChannelDAO;
import com.eureka.service.IService.ICacheService;
import com.eureka.utils.LocalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CacheService implements ICacheService {

	@Autowired
	private ChannelDAO channeDAO;

	@Override
	public CacheVO isCanUse(String from) {
		CacheVO level = LocalCache.getLevel(from);
		if (level == null) {
			level = channeDAO.getChannelLevel(from);
			if (level != null) {
				LocalCache.putLevel(level);
				level = isTimeOut(level);
				return level;
			}
		} else {
			level = isTimeOut(level);
			return level;
		}

		level = new CacheVO("无权渠道", 0);
		return level;
	}

	@Override
	public Map<String, String> secretMap(String param) {
		return null;
	}

	@Override
	public void flushCache() {
		LocalCache.flushAllCache();
	}

	private CacheVO isTimeOut(CacheVO level) {
		long startTime = level.getStartTime().getTime();
		long endTime = level.getEndTime().getTime();
		if ((endTime - startTime) <= 0) {
			level.setChannelId("渠道过期，请重新申请渠道编码");
			level.setLevel(0);
		}
		return level;
	}
}
