package com.example.cmisdemo.objectdefinitionserver.service;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.repository.ObjectDefinitionRepository;
import java.util.List;
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

  public ObjectDefinitionEntity getObjectDef(String repositoryId, long pk) {
    LOGGER.info("getObjectDefinition: " + pk);
    return objectDefinitionRepository.findById(pk).get();
  }

  public ObjectDefinitionEntity getObjectDefByTypeId(String repositoryId, String typeId) {
    LOGGER.info("getObjectDefinition: " + typeId);
    List<ObjectDefinitionEntity> objDefEs = objectDefinitionRepository.findByTypeId(typeId);
    if (objDefEs == null || objDefEs.isEmpty()) {
      return null;
    } else if (objDefEs.size() > 1) {
      throw new RuntimeException("found more than one element for key " + typeId);
    } else {
      return objDefEs.get(0);
    }
  }

  public Iterable<ObjectDefinitionEntity> getObjectDefs(String repositoryId) {
    LOGGER.info("getObjectDefs: start");
    return objectDefinitionRepository.findAll();
  }
}
