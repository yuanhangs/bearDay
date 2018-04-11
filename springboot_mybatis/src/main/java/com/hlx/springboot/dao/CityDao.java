package com.hlx.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlx.springboot.entity.City;

public interface CityDao {

	/**
	 * 根据城市名称，查询城市信息
	 * 
	 * @param cityName
	 *            城市名
	 */
	public City findCity(@Param("cityName") String cityName);
	
	
	public List<City> all();
}
