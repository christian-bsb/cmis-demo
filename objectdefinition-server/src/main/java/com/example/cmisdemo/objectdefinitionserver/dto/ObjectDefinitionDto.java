package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionDto {

  public ObjectDefinitionEntity objectTypeToObjectDefinitionEntity(ObjectType objectType) {

    ObjectDefinitionEntity objectDefinitionEntity = new ObjectDefinitionEntity();
    objectDefinitionEntity.setName(objectType.getDisplayName());
    return objectDefinitionEntity;
  }

  public ObjectType objectDefinitinEntityToObjectType(
      ObjectDefinitionEntity objectDefinitionEntity) {
    ObjectType objectType = new ObjectType();
    objectType.setDisplayName(objectDefinitionEntity.getName());
    return objectType;
  }
}
