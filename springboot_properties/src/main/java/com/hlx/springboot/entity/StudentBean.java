package com.hlx.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//同是用 @Component 作为 Bean 注入到 Spring 容器中。
@Component
@ConfigurationProperties(prefix="student")//将配置文件中以 student 前缀的属性值自动绑定到对应的字段中。
//@ConfigurationProperties(prefix="home") //改成home来调用这个配置文件application.yml
public class StudentBean {

	private String province; // 省份
	private String city; // 城市
	private String desc; // 描述

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "StudentBean [province=" + province + ", city=" + city
				+ ", desc=" + desc + "]";
	}

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentBean(String province, String city, String desc) {
		super();
		this.province = province;
		this.city = city;
		this.desc = desc;
	}

}
