package com.hlx.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hlx.springboot.entity.StudentBean;

/**
 * SpringBoot启动类
 * 
 * @author Administrator
 * 
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	//注入学生类
	@Autowired
	private StudentBean studentBean;

	/**
	 * 程序的入口点 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	/**
	 *运行输出结果
	 */
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(studentBean+"\n");

	}

}
