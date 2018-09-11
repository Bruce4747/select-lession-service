package com.eureka.service;

import com.eureka.vo.CacheVO;
import com.eureka.service.IService.ICacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CacheServiceTest {

	@Autowired
	private ICacheService cacheService;

	@Test
	public void isCanUse() {
		CacheVO canUse = cacheService.isCanUse("BLD_AQY_0615");
		System.out.println(canUse);
	}

	@Test
	public void secretMap() {
	}

	@Test
	public void flushCache() {
		cacheService.flushCache();
	}
}