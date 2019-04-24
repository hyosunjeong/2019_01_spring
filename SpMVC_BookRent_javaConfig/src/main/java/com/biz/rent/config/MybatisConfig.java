package com.biz.rent.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // <tx:annotation-driven>과 같음 =>mybatis-context.xml
@MapperScan("com.biz.rent.mapper") // <mybatis-spring:scan base-package="xom.biz.rent.mapper"와 같음
public class MybatisConfig {

	/*
	 * 1. dataSource
	 * 2. SqlSessionfactoryBean
	 * 3. transaction
	 * 4. SessionTemplet
	 */
	
	/*
	 * DataSource 생성
	 */
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("iolist");
		ds.setPassword("1234");
		
		return ds;
	}
	
	/*
	 * SqlSessionFactoryBean 설정
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		
		sf.setDataSource(ds());
		
		// model의 경로를 지정
		sf.setTypeAliasesPackage("com.biz.rent.model");
		
		return sf;
		
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager ts = new DataSourceTransactionManager(ds());
		
		
		return ts;
	}
	
}
