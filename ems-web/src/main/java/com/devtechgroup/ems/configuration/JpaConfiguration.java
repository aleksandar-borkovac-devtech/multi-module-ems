package com.devtechgroup.ems.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.devtechgroup.ems.data.access.repository")
public class JpaConfiguration {
}