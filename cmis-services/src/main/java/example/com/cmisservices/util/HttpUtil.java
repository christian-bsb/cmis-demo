package example.com.cmisservices.util;

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

public class HttpUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

  public static HttpResponse<String> sendPostRequest(String url, String json) throws Exception {
    LOGGER.info("url: " + url);
    HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();

    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

    // LOGGER.info("Response status code: " + response.statusCode());

    return response;
  }

  public static HttpResponse<String> sendGetRequest(String url) throws Exception {
    LOGGER.info("url: " + url);
    HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .GET()
            .build();

    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
    return response;
  }
}
