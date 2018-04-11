package com.hlx.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hlx.springboot.entity.City;
import com.hlx.springboot.service.CityService;

/**
 * 控制器
 * 
 * @author Administrator
 * 
 */
@RestController
public class CityRestController {

	// 注入业务
	@Autowired
	private CityService cityService;

	/**
	 * 返回JSON
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping("/my/add")
	public int addCity() {
		City city=new City(4L, 2L, "深圳市", "飞飞的家在深圳市");
		return cityService.add(city);
	}
	
	/**
	 * 返回JSON
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping("/my/del")
	public int delCity(@RequestParam(name = "id", required = true) int id) {
		return cityService.del(id);
	}

	/**
	 * 返回JSON
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping("/my/all")
	public List<City> allCity() {
		return cityService.list();
	}

	/**
	 * 返回JSON
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/my/find", method = RequestMethod.GET)
	public City findCity(
			@RequestParam(value = "cityName", required = true) String cityName) {
		return cityService.findCityName(cityName);
	}

}
