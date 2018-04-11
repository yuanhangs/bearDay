package com.hlx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlx.springboot.dao.cluster.CityDao;
import com.hlx.springboot.dao.master.UserDao;
import com.hlx.springboot.entity.City;
import com.hlx.springboot.entity.User;
import com.hlx.springboot.service.UserService;

/**
 * 
 * @author Administrator
 * 
 */
@Service
public class CityServiceImpl implements UserService {

	// 注入dao
	@Autowired
	private CityDao cityDao;

	@Autowired
	private UserDao userDao;

	@Override
	public User findUserName(String userName) {

		User user = userDao.findUser(userName);
		City city = cityDao.findCity("杭州市");
		user.setCity(city);
		return user;
	}

}
