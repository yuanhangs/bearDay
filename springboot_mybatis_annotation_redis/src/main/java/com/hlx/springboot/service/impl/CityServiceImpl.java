package com.hlx.springboot.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

	// 日志对象 org.slf4j.Logger
	private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

	// 注入dao
	@Autowired
	private CityDao cityDao;

	// 注入redisTemplate模板
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 
	 * (1)如果缓存存在，从缓存中获取城市信息
	 * 
	 * (2)如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
	 */
	@Override
	public City findCityName(Long id) {
		// 从缓存中获取
		String key = "city_" + id;
		
		System.out.println("findCityName===>"+key);
		
		// 操作视图接口类 String/Value 操作
		ValueOperations<String, City> operations = redisTemplate.opsForValue();
		// 缓存是否存在
		boolean flag = redisTemplate.hasKey(key);
		
		System.out.println("flag====>"+flag);
		// 判断
		if (flag) {
			// 获得value
			City city = operations.get(key);

			// 输出日志
			logger.info("CityServiceImpl.findCityName(),从缓存中获取数据:"
					+ city.toString());
			return city;

		}
		// 从 DB 中获取城市信息
		City citydb = cityDao.findCity(id);

		// 插入到缓存中
		operations.set(key, citydb, 10, TimeUnit.SECONDS);
		logger.info("CityServiceImpl.findCityName(),数据插入到缓存中:"
				+ citydb.toString());
		return citydb;
	}

	/**
	 * 查询所有的数据
	 */
	@Override
	public List<City> list() {
		
		// 从 DB 中获取城市信息
		List<City> list = cityDao.all();
		
		// 获得key
		String key = "city_" + list.size();

		// Redis List 操作
		ListOperations<String, City> listOperations = redisTemplate
				.opsForList();

		// 判断存在
		if (redisTemplate.hasKey(key)) {
			/**
			 * 获取指定key的范围内的value值的 list列表。 （0  -1）反回所有值列表 
			 */
			// 获得value
			List<City> citys = listOperations.range(key, 0, -1);
			// 输出日志
			logger.info("CityServiceImpl.list(),从缓存中获取数据:"
					+ citys.toString());
		}

		
		// 插入到缓存中
		listOperations.set(key, 0, list.get(0));
		logger.info("CityServiceImpl.list(),数据插入到缓存中:"
				+ list.toString());

		return list;
	}

	/**
	 * 添加数据
	 */
	@Override
	public Long add(City city) {
		// TODO Auto-generated method stub
		return cityDao.save(city);
	}

	/**
	 * 
	 * 删除
	 * (1)如果缓存存在，删除 (2)如果缓存不存在，不操作
	 */
	@Override
	public Long del(Long id) {
		// TODO Auto-generated method stub
		Long del = cityDao.delete(id);

		// 获得key
		String key = "city_" + id;

		// 判断是否存在缓存
		if (redisTemplate.hasKey(key)) {
			// 缓存存在，删除缓存
			redisTemplate.delete(key);

			// 日志跟踪
			logger.info("CityServiceImpl.del(),数据从缓存中删除>>>>" + id);
		}

		return del;
	}

	/**
	 * 
	 * 更新 (1)如果缓存存在，删除 (2)如果缓存不存在，不操作
	 */
	@Override
	public Long update(City city) {
		// TODO Auto-generated method stub
		Long my = cityDao.updates(city);
		
		System.out.println(my+"------>"+city);

		// 获得key
		String key = "city_" + city.getId();

		// 判断
		if (redisTemplate.hasKey(key)) {
			// 删除缓存
			redisTemplate.delete(key);

			// 日志跟踪
			logger.info("CityServiceImpl.update(),数据从缓存中删除>>>>" + my);
		}

		return my;
	}

}
