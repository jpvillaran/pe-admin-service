package com.patriotenergygroup.peadminservice.rates.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
  basePackages = { "com.patriotenergygroup.peadminservice.rates.repository" })
@EntityScan(basePackages = "com.patriotenergygroup.peadminservice.rates.model")
public class RatesDbConfiguration {

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "rates.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.patriotenergygroup.peadminservice.rates.domain")
				.persistenceUnit("rates")
				.build();
	}
	
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
	    return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean(name = "ratesLiquibaseProperties")
	@ConfigurationProperties("liquibase-changelogs.rates.liquibase")
	public LiquibaseProperties primaryLiquibaseProperties() {
	    return new LiquibaseProperties();
	}
	
	@Bean(name = "liquibase")
	public SpringLiquibase ratesLiquibase(
			@Qualifier("ratesLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
		SpringLiquibase rates = new SpringLiquibase();
	    rates.setDataSource(dataSource());
	    rates.setChangeLog(primaryLiquibaseProperties().getChangeLog());
	    return rates;
	}
}
