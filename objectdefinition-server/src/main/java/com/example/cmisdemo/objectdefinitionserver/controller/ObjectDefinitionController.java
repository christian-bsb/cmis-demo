package com.example.cmisdemo.objectdefinitionserver.controller;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.objectdefinitionserver.dto.ObjectDefinitionDto;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.service.ObjectDefinitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectDefinitionController {

  private static Logger LOGGER = LoggerFactory.getLogger(ObjectDefinitionController.class);

  @Autowired
  ObjectDefinitionService objectDefinitionService;

  @Autowired
  ObjectDefinitionDto objectDefinitionDto;

  @PostMapping(
      path = "repository/{repositoryId}/object/insert",
      consumes = "application/json",
      produces = "application/json")
  public ObjectType createObjectDefiniton(@PathVariable(value = "repositoryId") String repositoryId, @RequestBody ObjectType objectType) {
    LOGGER.info("insert object type {}", objectType.getDisplayName());
    ObjectDefinitionEntity objectDefinitionEntity = objectDefinitionDto.objectTypeToObjectDefinitionEntity(objectType);
    objectDefinitionEntity = objectDefinitionService.createObjectDefinition(repositoryId, objectDefinitionEntity);
    return objectDefinitionDto.objectDefinitinEntityToObjectType(objectDefinitionEntity);
  }


}
