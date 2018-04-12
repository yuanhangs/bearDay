package com.hlx.springboot.entity;

import java.io.Serializable;

/**
 * 实体类
 *  --实现序列化
 * @author Administrator
 * 
 */
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 城市编号
	 */
	private Long id;

	/**
	 * 省份编号
	 */
	private Long provinceId;

	/**
	 * 城市名称
	 */
	private String cityName;

	/**
	 * 描述
	 */
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", provinceId=" + provinceId + ", cityName="
				+ cityName + ", description=" + description + "]";
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(Long id, Long provinceId, String cityName, String description) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.cityName = cityName;
		this.description = description;
	}

}
