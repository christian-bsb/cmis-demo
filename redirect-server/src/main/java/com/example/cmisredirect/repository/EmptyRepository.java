package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.RepositoryInfo;
import org.springframework.stereotype.Service;

@Service
public class EmptyRepository implements Repository {

  @Override
  public RepositoryInfo getInfo() {
    return new RepositoryInfo("");
  }

  @Override
  public ObjectType createType(ObjectType objectType) throws Exception {
    throw new NoSuchMethodException();
  }

  @Override
  public ObjectType getTypeDefinition(String typeId) {
    return null;
  }

  @Override
  public Folder createFolder(Folder folder) throws Exception {
    throw new NoSuchMethodException();
  }
}
