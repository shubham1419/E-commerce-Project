package com.shubham.EcommerceBackend.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages= {"com.shubham.EcommerceBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "dbc:mysql://localhost/ecommerce";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "";

	//Data source
	@Bean
	public DataSource getDataSource() throws PropertyVetoException
	{
		ComboPooledDataSource datasource = new ComboPooledDataSource(); 
		//database connection information
		datasource.setDriverClass(DATABASE_DRIVER);
		datasource.setJdbcUrl( DATABASE_URL ); 
		datasource.setUser(DATABASE_USERNAME); 
		datasource.setPassword(DATABASE_PASSWORD);
				
		return datasource;		
	}
	
	//session factory
	@Bean 
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.shubham.EcommerceBackend.dto");
		return builder.buildSessionFactory();
	}

	//all hibernate properties return here
	private Properties getHibernateProperties() {
		Properties property = new Properties();
		property.put("hibernate.dialect",DATABASE_DIALECT);
		property.put("hibernate.show_sql","true");
		property.put("hibernate.format_sql","true");
		return property;
	}
	
	//for transaction management
	@Bean 
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
