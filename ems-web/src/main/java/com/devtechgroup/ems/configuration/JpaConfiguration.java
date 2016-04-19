package com.devtechgroup.ems.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@PropertySource("classpath:application.properties")
@Configuration
@EnableJpaRepositories(basePackages = "com.devtechgroup.ems.data.access.repository")
public class JpaConfiguration {

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.datasource.username}")
    private String springDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String springDatasourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String springDatasourceDriver;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(springDatasourceUrl);
        driverManagerDataSource.setUsername(springDatasourceUsername);
        driverManagerDataSource.setPassword(springDatasourcePassword);
        driverManagerDataSource.setDriverClassName(springDatasourceDriver);
        return driverManagerDataSource;
    }

    /*String sqlQuery = "CREATE SCHEMA `ems` ;\n" +
            "\n" +
            "CREATE  TABLE authority (\n" +
            "authority_name VARCHAR(45) NOT NULL ,\n" +
            "PRIMARY KEY (authority_name));\n" +
            "\n" +
            "INSERT INTO authority (authority_name)\n" +
            "VALUES ('ROLE_USER');\n" +
            "INSERT INTO authority (authority_name)\n" +
            "VALUES ('ROLE_ADMIN');\n" +
            "INSERT INTO authority (authority_name)\n" +
            "VALUES ('ROLE_SUPER');";
    org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.execute(sqlQuery);*/

}