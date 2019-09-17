package com.santosh.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.santosh.shoppingbackend" })
@EnableTransactionManagement
public class HibernateConfig {
	private static final String mysql_dialect = "org.hibernate.dialect.MySQL5Dialect";
	private static final String mysql_driver = "com.mysql.jdbc.Driver";
	private static final String mysql_url = "jdbc:mysql://localhost:3306/shoppingsite";
	private static final String mysql_user = "root";
	private static final String mysql_password = "root";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(mysql_driver);
		dataSource.setUrl(mysql_url);
		dataSource.setUsername(mysql_user);
		dataSource.setPassword(mysql_password);
		return dataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.santosh.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", mysql_dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
