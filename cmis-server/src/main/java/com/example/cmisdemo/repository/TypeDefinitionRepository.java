package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TypeDefinitionRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(TypeDefinitionRepository.class);

  @Value("${object-type-server.url}")
  private String baseUrl;

  ObjectMapper mapper = new ObjectMapper();

  Map<String, ObjectType> objectTypeMap = new HashMap<>();

  public TypeDefinitionRepository() {
    objectTypeMap.put("0", new ObjectType("0", "Empty Object Type"));
  }

  public ObjectType createType(ObjectType objectType) throws Exception {
    String url = baseUrl + "/repository/1/object/insert";
    HttpResponse<String> response =
        HttpUtil.sendPostRequest(url, mapper.writeValueAsString(objectType));
    LOGGER.info(response.body());
    String objectTypeJsonString = response.body();
    ObjectType respObjectType = mapper.readValue(objectTypeJsonString, ObjectType.class);

    return respObjectType;
  }

  public ObjectType getTypeDefinition(String typeId) {
    return objectTypeMap.get(typeId);
  }
}
