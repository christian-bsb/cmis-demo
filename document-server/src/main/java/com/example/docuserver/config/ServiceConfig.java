package com.example.docuserver.config;

import example.com.cmisservices.repository.TypeDefinitionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Value("${cmis.server.url}")
  private String cmisServerUrl;

  @Bean
  TypeDefinitionRepository getTypeDefinitionRepository() {
    return new TypeDefinitionRepository(cmisServerUrl);
  }
}
