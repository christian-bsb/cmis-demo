package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.RepositoryInfo;

public interface Repository {

  RepositoryInfo getInfo();

  ObjectType createType(ObjectType objectType) throws Exception;

  ObjectType getTypeDefinition(String typeId);

  Folder createFolder(Folder folder) throws Exception;
}
