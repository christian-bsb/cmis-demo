package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.ObjectType;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class TypeDefinitionRepository {

  Map<String, ObjectType> objectTypeMap = new HashMap<>();

  public TypeDefinitionRepository() {
    objectTypeMap.put("0", new ObjectType("0", "Empty Object Type"));
  }

  public ObjectType createType(ObjectType objectType) throws Exception {
    objectTypeMap.put(objectType.getId(), objectType);
    return objectType;
  }

  public ObjectType getTypeDefinition(String typeId) {
    return objectTypeMap.get(typeId);
  }
}
