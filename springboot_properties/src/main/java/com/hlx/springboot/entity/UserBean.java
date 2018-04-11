package com.hlx.springboot.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
public class UserBean {
	private Long id; // 编号
	private int age;// 年龄
	private String username;// 姓名
	private String uuid;// 用户 UUID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", age=" + age + ", username=" + username
				+ ", uuid=" + uuid + "]";
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(Long id, int age, String username, String uuid) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.uuid = uuid;
	}

}
