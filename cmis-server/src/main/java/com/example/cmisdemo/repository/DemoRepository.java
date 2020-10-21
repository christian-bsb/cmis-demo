package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.RepositoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoRepository implements Repository {

  TypeDefinitionRepository typeDefinitionRepository;

  @Autowired
  public DemoRepository(TypeDefinitionRepository typeDefinitionRepository) {
    this.typeDefinitionRepository = typeDefinitionRepository;
  }

  @Override
  public RepositoryInfo getInfo() {
    RepositoryInfo info = new RepositoryInfo();
    info.setId("1");
    info.setName("Demo");
    info.setDescription("Demo Repository");
    return info;
  }

  @Override
  public ObjectType createType(ObjectType objectType) throws Exception {
    return typeDefinitionRepository.createType(objectType);
  }

  @Override
  public ObjectType getTypeDefinition(String typeId) {
    return typeDefinitionRepository.getTypeDefinition(typeId);
  }

  @Override
  public Folder createFolder(Folder folder) throws Exception {
    return folder;
  }
}
