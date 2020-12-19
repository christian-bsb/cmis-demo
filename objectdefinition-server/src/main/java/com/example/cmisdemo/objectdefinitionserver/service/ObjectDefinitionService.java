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
    return objectDefinitionRepository.save(objDefE);
  }

  public ObjectDefinitionEntity getObjectDef(String repositoryId, long typeId) {
    LOGGER.info("getObjectDefinition: " + typeId);
    return objectDefinitionRepository.findById(typeId).get();
  }

  public Iterable<ObjectDefinitionEntity> getObjectDefs(String repositoryId) {
    LOGGER.info("getObjectDefs: start");
    return objectDefinitionRepository.findAll();
  }
}
