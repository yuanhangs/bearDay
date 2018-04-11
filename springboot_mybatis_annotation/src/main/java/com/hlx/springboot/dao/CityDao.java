package com.hlx.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hlx.springboot.entity.City;

/**
 * DAO 接口类
 * 
 * @author Administrator
 * 
 */
@Mapper
// 这个注解是Mybatis 的 Mapper(无需配置文件)
public interface CityDao {

	/**
	 * 根据城市名称，查询城市信息
	 * 
	 * @param cityName
	 *            城市名
	 */
	@Select("select * from city where city_name=#{cityName}")
	// 查询语句
	// 返回 Map 结果集
	@Results({ @Result(column = "id", property = "id"),
			@Result(column = "province_id", property = "provinceId"),
			@Result(column = "city_name", property = "cityName"),
			@Result(column = "description", property = "description")

	})
	public City findCity(@Param("cityName") String cityName);

	/**
	 * 查询语句
	 * 
	 * 注意:属性与数据列名不一致就会显示NUll,那么就必须配置ResultMap一一对应
	 * @return
	 */
	@Select("select * from city")
	// 返回 Map 结果集
	@Results({ @Result(column = "id", property = "id"),
			@Result(column = "province_id", property = "provinceId"),
			@Result(column = "city_name", property = "cityName"),
			@Result(column = "description", property = "description")

	})
	public List<City> all();

	/**
	 * 根据ID删除数据
	 * 
	 * @param id
	 * @return
	 */
	@Delete("delete from city where id=#{id}")
	int delete(int id);

	/**
	 * 添加数据
	 * 
	 * @param city
	 * @return
	 */
	@Insert("insert into city values(#{id},#{provinceId},#{cityName},#{description})")
	int save(City city);
}
