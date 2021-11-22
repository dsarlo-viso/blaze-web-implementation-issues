package com.blaze.spring.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories ("com.blaze.spring.example.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
