package com.hlx.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * 添加数据
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/your/city", method = RequestMethod.POST)
	public Long addCity(@RequestBody City city) {
		return cityService.add(city);
	}

	/**
	 * 
	 * 更新数据
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/your/city", method = RequestMethod.PUT)
	public void updateCity(@RequestBody City city) {
		cityService.update(city);
	}

	/**
	 * 
	 * 删除数据
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/your/city/{id}", method = RequestMethod.DELETE)
	public Long updateCity(@PathVariable("id") Long id) {
		return cityService.del(id);
	}

	/**
	 * 
	 * 
	 * @param cityName
	 * @return
	 */
	// @RequestMapping("/your/city")
	// public List<City> allCity() {
	// return cityService.list();
	// }

	/**
	 * 查询一条数据
	 * 
	 * @param cityName
	 * @return
	 */
	@RequestMapping(value = "/your/city/{id}", method = RequestMethod.GET)
	public City findCity(@PathVariable("id") Long id) {
		return cityService.findCityName(id);
	}

}
