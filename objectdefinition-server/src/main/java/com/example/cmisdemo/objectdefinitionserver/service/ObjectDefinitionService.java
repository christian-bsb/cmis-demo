package com.example.cmisdemo.objectdefinitionserver.service;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.repository.ObjectDefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionService {

  private static Logger LOGGER = LoggerFactory.getLogger(ObjectDefinitionService.class);

  @Autowired ObjectDefinitionRepository objectDefinitionRepository;

  public ObjectDefinitionEntity createObjDef(String repId, ObjectDefinitionEntity objDefE) {
    LOGGER.info("createObjectDefinition: " + objDefE);
    objectDefinitionRepository.save(objDefE);
    return objDefE;
  }

  public ObjectDefinitionEntity getObjectDefinition(String repositoryId, long typeId) {
    return objectDefinitionRepository.findById(typeId).get();
  }
}