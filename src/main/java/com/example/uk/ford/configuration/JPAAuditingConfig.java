package com.example.uk.ford.configuration;

import com.example.uk.ford.Repository.StudentRepositoryInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
//@EnableJpaRepositories(repositoryFactoryBeanClass = StudentRepositoryInterface.class)
public class JPAAuditingConfig {
}
