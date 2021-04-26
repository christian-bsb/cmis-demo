package com.example.cmisdemo.repository;

import com.example.cmisdemo.model.Folder;
import org.springframework.stereotype.Component;

@Component
public class DictionaryRepository {

  public Folder createFolder(Repository repository, Folder folder) {

    folder.setId("1");
    return folder;
  }
}
