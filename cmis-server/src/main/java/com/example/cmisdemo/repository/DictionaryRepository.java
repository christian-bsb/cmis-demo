package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DictionaryRepository {

  public Folder createFolder(Repository repository, Folder folder) {

    folder.setId("1");
    return folder;
  }

}
