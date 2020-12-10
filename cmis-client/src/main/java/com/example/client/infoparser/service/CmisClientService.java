package com.example.client.infoparser.service;

import com.example.cmisdemo.model.Document;
import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.com.cmisservices.repository.DocumentRepository;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CmisClientService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CmisClientService.class);

  @Autowired DocumentRepository documentRepository;

  ObjectMapper mapper;

  @Value("${cmis.server.url}")
  private String baseurl;

  public CmisClientService() {
    mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
  }

  public void save(Folder folder) throws Exception {
    sendPostRequest(baseurl + "/repository/1/folders", mapper.writeValueAsString(folder));
    return;
  }

  public String createObjectType(String repositoryId, ObjectType objectType) throws Exception {
    HttpResponse<String> response =
        sendPostRequest(
            baseurl + "/repository/" + repositoryId + "/types",
            mapper.writeValueAsString(objectType));
    return response.body();
  }

  public ObjectType getTypeDefiniton(String repositoryId, String typeId) throws Exception {
    HttpResponse<String> response =
        sendGetRequest(baseurl + "/repository/" + repositoryId + "/type/" + typeId);
    String body = response.body();
    return mapper.readValue(body, ObjectType.class);
  }

  // Documents ///////////////////////////////////////////////////////////////////

  public String createDocument(String repositoryId, String folderId, Document document)
      throws Exception {

    return documentRepository.createDocument(document);
  }

  HttpResponse<String> sendPostRequest(String url, String json) throws Exception {
    HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();

    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

    LOGGER.info("Response status code: " + response.statusCode());
    LOGGER.info("Response headers: " + response.headers());
    LOGGER.info("Response body: " + response.body());
    return response;
  }

  HttpResponse<String> sendGetRequest(String url) throws Exception {
    HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .GET()
            .build();

    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

    LOGGER.info("Response status code: " + response.statusCode());
    LOGGER.info("Response headers: " + response.headers());
    LOGGER.info("Response body: " + response.body());
    return response;
  }
}
