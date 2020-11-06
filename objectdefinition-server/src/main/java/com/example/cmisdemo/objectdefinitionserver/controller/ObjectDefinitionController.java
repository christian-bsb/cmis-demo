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

  @Autowired ObjectDefinitionService objDefServ;

  @Autowired ObjectDefinitionDto objDefDto;

  @PostMapping(
      path = "repository/{repositoryId}/object/insert",
      consumes = "application/json",
      produces = "application/json")
  public ObjectType createObjectDefiniton(
      @PathVariable(value = "repositoryId") String repositoryId,
      @RequestBody ObjectType objectType) {
    LOGGER.info("insert object type {}", objectType.getDisplayName());
    ObjectDefinitionEntity objDefE = objDefDto.objTypeToObjDefE(objectType);
    objDefE = objDefServ.createObjDef(repositoryId, objDefE);
    return objDefDto.objDefEToObjType(objDefE);
  }
}
