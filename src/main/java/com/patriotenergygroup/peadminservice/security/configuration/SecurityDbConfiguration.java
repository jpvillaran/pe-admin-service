package com.patriotenergygroup.peadminservice.security.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "securityEntityManagerFactory", 
	transactionManagerRef = "securityTransactionManager",
	basePackages = { "com.patriotenergygroup.peadminservice.security.repository" })
public class SecurityDbConfiguration {

	@Bean(name = "securityDataSource")
	@ConfigurationProperties(prefix = "security.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "securityEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean securityEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("securityDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.patriotenergygroup.peadminservice.security.domain")
				.persistenceUnit("security")
				.build();
	}
	
	@Bean(name = "securityTransactionManager")
	public PlatformTransactionManager securityTransactionManager(
			@Qualifier("securityEntityManagerFactory") EntityManagerFactory securityEntityManagerFactory) {
		return new JpaTransactionManager(securityEntityManagerFactory);
	}
	
	@Bean(name = "securityLiquibaseProperties")
	@ConfigurationProperties("liquibase-changelogs.security.liquibase")
	public LiquibaseProperties securityLiquibaseProperties() {
	    return new LiquibaseProperties();
	}
	
	@Bean(name = "securityLiquibase")
	public SpringLiquibase securityLiquibase(
			@Qualifier("securityLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
		SpringLiquibase security = new SpringLiquibase();
		security.setDataSource(dataSource());
		security.setChangeLog(securityLiquibaseProperties().getChangeLog());
	    return security;
	}
}
