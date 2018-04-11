package com.hlx.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hlx.springboot.web.HelloController;

/**
 * 单元测试
 * 
 * @author Administrator
 * 
 */
public class TestHelloController {

	@Test
	public void test() throws Exception {
		// assertEquals("Hello,World!",new HelloController().show());
		System.out.println(new HelloController().show());
	}
}
