package com.hlx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlx.springboot.dao.CityDao;
import com.hlx.springboot.entity.City;
import com.hlx.springboot.service.CityService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class CityServiceImpl implements CityService {
	
	//注入dao
	@Autowired
	private CityDao cityDao;

	@Override
	public City findCityName(String cityName) {
		// TODO Auto-generated method stub
		return cityDao.findCity(cityName);
	}

	@Override
	public List<City> list() {
		// TODO Auto-generated method stub
		return cityDao.all();
	}

	@Override
	public int add(City city) {
		// TODO Auto-generated method stub
		return cityDao.save(city);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return cityDao.delete(id);
	}

}
