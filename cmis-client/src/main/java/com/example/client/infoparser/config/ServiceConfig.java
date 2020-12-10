package com.example.client.infoparser.config;

import example.com.cmisservices.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Value("${cmis.server.url}")
  private String cmisServerUrl;

  @Bean
  DocumentRepository getDocumentRepository() {
    return new DocumentRepository(cmisServerUrl);
  }
}
