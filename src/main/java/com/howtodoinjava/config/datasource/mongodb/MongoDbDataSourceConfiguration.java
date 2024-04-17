package com.howtodoinjava.config.datasource.mongodb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mongoEntityManagerFactory", transactionManagerRef = "mongoTransactionManager", basePackages = {
		"com.howtodoinjava.repositories.mongodb" })

public class MongoDbDataSourceConfiguration {
	@Bean(name = "mongodbProperties")
	@ConfigurationProperties("spring.data.multi")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "mongodbDatasource")
	@ConfigurationProperties(prefix = "spring.data.multi")
	public DataSource datasource(@Qualifier("mongodbProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean(name = "mongoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("mongodbDatasource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("com.howtodoinjava.model.mongo").persistenceUnit("mongodb")
				.build();
	}

	@Bean(name = "mongoTransactionManager")
	@ConfigurationProperties("spring.jpa")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mongoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

		return new JpaTransactionManager(entityManagerFactory);
	}
}
