package com.hlx.springboot.service;

import java.util.List;

import com.hlx.springboot.entity.City;

public interface CityService {
	/**
	 * 根据城市名查找城市
	 * 
	 * @param cityName
	 * @return
	 */
	public City findCityName(String cityName);

	// 添加
	void add(City city);

	// 修改
	void update(String cityName, String description);

}
