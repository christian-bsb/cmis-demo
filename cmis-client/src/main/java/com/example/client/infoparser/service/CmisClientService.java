package com.example.client.infoparser.service;

import com.example.cmisdemo.model.Folder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CmisClientService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CmisClientService.class);

  ObjectMapper mapper = new ObjectMapper();

  @Value("${cmis.server.url}")
  private String baseurl;

  public void save(Folder folder) throws Exception {

    String json = mapper.writeValueAsString(folder);
    // System.out.println(json);

    HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(baseurl + "/repository/1/folders"))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();

    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

    LOGGER.info("Response status code: " + response.statusCode());
    LOGGER.info("Response headers: " + response.headers());
    LOGGER.info("Response body: " + response.body());

    return;
  }
}
