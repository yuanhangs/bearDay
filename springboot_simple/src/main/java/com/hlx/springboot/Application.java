package com.hlx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot(英文中是“引导”的意思)，是用来简化Spring应用的搭建到开发的过程。应用开箱即用，只要通过 “just run”（可能是
 * java -jar 或 tomcat 或 maven插件run 或 shell脚本），就可以启动项目。二者，Spring Boot
 * 只要很少的Spring配置文件（例如那些xml，property）。
 * 
 * @author Administrator Spring Boot应用启动类
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件
		SpringApplication.run(Application.class, args);
	}
}
