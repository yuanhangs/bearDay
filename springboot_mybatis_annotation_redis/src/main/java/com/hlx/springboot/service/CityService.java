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
	public City findCityName(Long id);

	/**
	 * 查询所有的城市
	 * 
	 * @return
	 */
	public List<City> list();

	Long add(City city);
	
	Long update(City city);

	Long del(Long id);
}
