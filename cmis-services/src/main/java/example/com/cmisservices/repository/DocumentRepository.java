package example.com.cmisservices.repository;

import com.example.cmisdemo.model.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.com.cmisservices.util.HttpUtil;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentRepository.class);
  private String baseUrl;
  ObjectMapper mapper = new ObjectMapper();

  public DocumentRepository(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String createDocument(Document document) throws Exception {

    String url = baseUrl + "/repository/1/folder/1/documents";
    HttpResponse<String> response =
        HttpUtil.sendPostRequest(url, mapper.writeValueAsString(document));
    LOGGER.info(response.body());
    String objectTypeJsonString = response.body();
    // Document respDoc = mapper.readValue(objectTypeJsonString, Document.class);

    return objectTypeJsonString;
  }

  public Document getDocument(String repositoryId, String documentId) throws Exception {

    String url = baseUrl + "/repository/" + repositoryId + "/document/" + documentId;
    HttpResponse<String> response = HttpUtil.sendGetRequest(url);
    LOGGER.info(response.body());
    String resp = response.body();
    Document respDoc = mapper.readValue(resp, Document.class);

    return respDoc;
  }
}
