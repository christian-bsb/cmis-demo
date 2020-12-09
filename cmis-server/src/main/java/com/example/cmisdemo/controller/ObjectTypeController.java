package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.service.RepositoryService;
import example.com.cmisservices.repository.TypeDefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectTypeController {

  @Autowired RepositoryService repositoryService;

  @Autowired TypeDefinitionRepository typeDefinitionRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(ObjectTypeController.class);

  @PostMapping("/repository/{repositoryId}/types")
  ObjectType createType(@RequestBody ObjectType objectType, @PathVariable String repositoryId)
      throws Exception {
    LOGGER.info(objectType.toString());
    ObjectType newType = typeDefinitionRepository.createType(objectType);
    // Repository repository = repositoryService.getRepository(repositoryId);
    // return repository.createType(objectType);
    return newType;
  }

  @GetMapping("/repository/{repositoryId}/type/{typeid}")
  public ObjectType getTypeDeﬁnition(@PathVariable String repositoryId, @PathVariable String typeid)
      throws Exception {
    ObjectType objType = repositoryService.getRepository(repositoryId).getTypeDefinition(typeid);
    LOGGER.info("request rep: " + repositoryId + " type: " + typeid + " resp: " + objType);
    return objType;
  }
}
