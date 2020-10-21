package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.repository.Repository;
import com.example.cmisdemo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectTypeController {

  @Autowired RepositoryService repositoryService;

  @PostMapping("/repository/{repositoryId}/types")
  ObjectType createType(@RequestBody ObjectType objectType, @PathVariable String repositoryId)
      throws Exception {
    Repository repository = repositoryService.getRepository(repositoryId);
    return repository.createType(objectType);
  }

  @GetMapping("/repository/{repositoryId}/type/{typeid}")
  public ObjectType getTypeDeﬁnition(
      @PathVariable String repositoryId, @PathVariable String typeid) {
    return repositoryService.getRepository(repositoryId).getTypeDefinition(typeid);
  }
}
