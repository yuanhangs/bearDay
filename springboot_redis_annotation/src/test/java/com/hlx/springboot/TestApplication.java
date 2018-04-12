package com.hlx.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hlx.springboot.entity.City;
import com.hlx.springboot.service.CityService;
import com.hlx.springboot.service.impl.CityServiceImpl;

@RunWith(SpringRunner.class)
// run
@SpringBootTest
// springboot test
public class TestApplication {
	// 日志对象
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CityServiceImpl.class);

	// 注入接口
	@Autowired
	public CityService cityService;

	/**
	 * 添加
	 */
	@Test
	public void testAdd() {
		// 城市对象
		City city = new City(8L, 10L, "上海", "人称魔都的地方");

		// 添加=> 向 redis 中存入数据
		cityService.add(city);

		// 从 redis 中取数据
		City citys = cityService.findCityName("上海");

		// 日志跟踪
		LOGGER.info(citys.toString());

	}

	/**
	 * 更新
	 */
	@Test
	public void testUpdate() {
		// 城市对象
		City city = new City(9L, 20L, "北京", "中国帝都");
		
		// 添加=> 向 redis 中存入数据
		cityService.add(city);

		// 从 redis 中取数据, 第一次查询
		City citys = cityService.findCityName("北京");
		// 日志跟踪
		LOGGER.info("first find BJ=>" + citys.toString());

		// 从 redis 中取数据, 第一次查询
		citys = cityService.findCityName("北京");
		// 日志跟踪
		LOGGER.info("second find BJ=>" + citys.toString());

		// 更新 city 的描述信息后查询
		cityService.update("北京", "很想去北京玩玩!");
		citys = cityService.findCityName("北京");
		// 日志跟踪
		LOGGER.info("update after BJ=>" + citys.toString());

	}
}
