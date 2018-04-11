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

	/**
	 * 查询所有的城市
	 * 
	 * @return
	 */
	public List<City> list();

	int add(City city);

	int del(int id);
}
