package com.hlx.springboot.entity;

public class User {
	/**
	 * 城市编号
	 */
	private Long id;

	/**
	 * 城市名称
	 */
	private String userName;

	// 所在的城市(在cluster)
	private City city;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
