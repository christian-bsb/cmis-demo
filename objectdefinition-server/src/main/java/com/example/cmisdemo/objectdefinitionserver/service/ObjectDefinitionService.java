package com.example.cmisdemo.objectdefinitionserver.service;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.repository.ObjectDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionService {

  @Autowired ObjectDefinitionRepository objectDefinitionRepository;

  public ObjectDefinitionEntity createObjectDefinition(
      String repositoryId, ObjectDefinitionEntity objectDefinitionEntity) {
    objectDefinitionRepository.save(objectDefinitionEntity);
    return objectDefinitionEntity;
  }

  public ObjectDefinitionEntity getObjectDefinition(String repositoryId, long typeId) {
    return objectDefinitionRepository.findById(typeId).get();
  }
}
