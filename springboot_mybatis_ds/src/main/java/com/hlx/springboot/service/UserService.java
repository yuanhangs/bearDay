package com.hlx.springboot.service;

import java.util.List;

import com.hlx.springboot.entity.City;
import com.hlx.springboot.entity.User;

public interface UserService {
	/**
	 * 根据姓名查找用户信息
	 * 
	 * @param cityName
	 * @return
	 */
	public User findUserName(String userName);

	
}
