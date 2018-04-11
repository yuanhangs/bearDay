package com.hlx.springboot.config.ds;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
//sqlSessionFactoryRef表示定义了 key ，表示一个唯一 SqlSessionFactory 实例
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
	// 精确到 master 目录，以便跟其他数据源隔离
	static final String PACKAGE = "com.hlx.springboot.dao.master";
	// static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

	// 获取全局配置文件 application.properties 的 key=value 配置,并自动装配
	@Value("${master.datasource.url}")
	private String url;

	@Value("${master.datasource.username}")
	private String user;

	@Value("${master.datasource.password}")
	private String password;

	@Value("${master.datasource.driver-class-name}")
	private String driverClass;

	/**
	 * 数据源
	 * 
	 * @return
	 */
	@Bean(name = "masterDataSource")
	@Primary
	// 多数据源配置的时候注意，必须要有一个主数据源
	public DataSource masterDataSource() {
		// 数据源对象
		DruidDataSource dataSource = new DruidDataSource();
		// 将值设置中
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	/**
	 * 事务管理
	 * 
	 * @return
	 */
	@Bean(name = "masterTransactionManager")
	@Primary
	// 多数据源配置的时候注意，必须要有一个主数据源
	public DataSourceTransactionManager masterTransactionManager() {
		// spring事务管理
		return new DataSourceTransactionManager(masterDataSource());
	}

	/**
	 * 会话工厂
	 * 
	 * @param masterDataSource
	 * @return
	 * @throws Exception
	 */

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	// 多数据源配置的时候注意，必须要有一个主数据源
	public SqlSessionFactory masterSqlSessionFactory(
			@Qualifier("masterDataSource") DataSource masterDataSource)
			throws Exception {
		// 会话工厂对象
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		// 设置数据源
		sessionFactory.setDataSource(masterDataSource);
		// 设置xml路径
		// sessionFactory
		// .setMapperLocations(new PathMatchingResourcePatternResolver()
		// .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
