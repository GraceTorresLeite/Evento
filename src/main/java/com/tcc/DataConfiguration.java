package com.tcc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource =  new DriverManagerDataSource();		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//("jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC"
		dataSource.setUrl("jdbc:mysql://localhost:3306/scheduleapp?useSSL=false&useTimezone=true&serverTimezone=UTC");//scheduleapp nome do schema
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);//define database
		adapter.setShowSql(true);// mostra no terminal os comandos
		adapter.setGenerateDdl(true);//crie tabelas automaticamente
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		adapter.setPrepareConnection(true);//se conecta automatico
		return adapter;
		
	}

}
