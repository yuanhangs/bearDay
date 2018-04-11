package com.hlx.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hlx.springboot.entity.City;
import com.hlx.springboot.entity.User;
import com.hlx.springboot.service.UserService;

/**
 * 控制器
 * 
 * @author Administrator
 * 
 */
@RestController
public class UserRestController {

	// 注入业务
	@Autowired
	private UserService userService;

	/**
	 * 返回JSON
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/my/user", method = RequestMethod.GET)
	public User findUser(
			@RequestParam(value = "userName", required = true) String userName) {
		return userService.findUserName(userName);
	}

}
