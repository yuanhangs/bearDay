package com.hlx.springboot.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hlx.springboot.entity.StudentBean;
import com.hlx.springboot.entity.UserBean;

/**
 * 自定义配置文件测试类
 * 
 * @author Administrator
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProperties {

	// 获得日志对象
	private final Logger logger = LoggerFactory.getLogger(TestProperties.class);

	// 注入学生类
	@Autowired
	private StudentBean studentBean;

	// 注入用户类
	@Autowired
	private UserBean userBean;

	// 测试学生
	@Test
	public void testStudent() {
		logger.info("\n\n"+studentBean + "\n");
	}

	// 测试用户
	@Test
	public void testUser() {
		logger.info("\n\n"+userBean + "\n");
	}
}
