package com.hlx.springboot.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hlx.springboot.entity.City;
import com.hlx.springboot.service.CityService;

/**
 * 
 * @author Administrator
 * 
 */
@Service
public class CityServiceImpl implements CityService {

	// 模拟数据库存储
	private Map<String, City> maps = new HashMap<String, City>();

	/**
	 * 查找
	 */
	@Override
	@Cacheable(value="baseCityInfo")
	//调用这个方法,会从baseCityInfo的名称缓存中查询，如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，
	//否则返回缓存中的对象
	public City findCityName(String cityName) {
		// 模拟数据库查询并返回
		return maps.get(cityName);
	}

	/**
	 * 添加
	 */
	@Override
	public void add(City city) {
		// TODO Auto-generated method stub
		maps.put(city.getCityName(), city);

	}

	/**
	 * 更新
	 */
	@Override
	@CachePut(value="baseCityInfo")
	//确保方法被执行，同时方法的返回值也被记录到缓存中，实现缓存与数据库的同步更新。
	public void update(String cityName, String description) {
		// 获得城市
		City city = maps.get(cityName);
		// 设置描述
		city.setDescription(description);

		// 保存到数据中
		maps.put(cityName, city);

	}

}
