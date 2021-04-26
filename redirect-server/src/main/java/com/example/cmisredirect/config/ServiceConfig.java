package com.example.cmisredirect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Value("${object-type-server.url}")
  private String objectTypeServerUrl;

  @Value("${document-server.url}")
  private String documentServerUrl;
}
