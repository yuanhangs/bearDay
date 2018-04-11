package com.hlx.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot
 * @author Administrator
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/") //访问根目录
	public String show() throws Exception{
		return "this is Spring-boot Test!";
	
	}
}
