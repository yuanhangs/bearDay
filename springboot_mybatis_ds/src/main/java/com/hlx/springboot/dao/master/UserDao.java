package com.hlx.springboot.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hlx.springboot.entity.User;

@Mapper
public interface UserDao {

	/**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
	@Select("select * from user where user_name=#{userName}")
	@Results({
		@Result(column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="description",property="description")
	})
	public User findUser(@Param("userName") String userName);
}
