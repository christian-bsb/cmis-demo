package example.com.cmisservices.repository;

import com.example.cmisdemo.model.ObjectType;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.com.cmisservices.util.HttpUtil;
import java.net.http.HttpResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeDefinitionRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(TypeDefinitionRepository.class);

  private String baseUrl;

  ObjectMapper mapper = new ObjectMapper();

  public TypeDefinitionRepository(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public ObjectType createType(ObjectType objectType) throws Exception {
    String url = baseUrl + "/repository/1/type/" + objectType.getTypeId() + "/update";
    HttpResponse<String> response =
        HttpUtil.sendPostRequest(url, mapper.writeValueAsString(objectType));
    LOGGER.info(response.body());
    String objectTypeJsonString = response.body();
    ObjectType respObjectType = mapper.readValue(objectTypeJsonString, ObjectType.class);

    return respObjectType;
  }

  public ObjectType updateType(ObjectType objectType) throws Exception {
    return createType(objectType);
  }

  public ObjectType getTypeDefinition(String typeId) throws Exception {
    String url = baseUrl + "/repository/1/type/" + typeId;
    HttpResponse<String> response = HttpUtil.sendGetRequest(url);
    LOGGER.info(response.body());
    String objectTypeJsonString = response.body();
    ObjectType respObjectType = mapper.readValue(objectTypeJsonString, ObjectType.class);
    return respObjectType;
  }

  public List<ObjectType> getTypeDefinitions() throws Exception {
    String url = baseUrl + "/repository/1/types";
    HttpResponse<String> response = HttpUtil.sendGetRequest(url);
    LOGGER.info(response.body());
    String objectTypeJsonString = response.body();
    List<ObjectType> respObjectTypes = mapper.readValue(objectTypeJsonString, List.class);
    return respObjectTypes;
  }
}
