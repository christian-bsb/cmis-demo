package com.example.cmisdemo.config;

import example.com.cmisservices.repository.DocumentRepository;
import example.com.cmisservices.repository.TypeDefinitionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Value("${object-type-server.url}")
  private String objectTypeServerUrl;

  @Value("${document-server.url}")
  private String documentServerUrl;

  @Bean
  TypeDefinitionRepository getTypeDefinitionRepository() {
    return new TypeDefinitionRepository(objectTypeServerUrl);
  }

  @Bean
  DocumentRepository getDocumentRepository() {
    return new DocumentRepository(documentServerUrl);
  }
}
