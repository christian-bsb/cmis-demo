package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.repository.Repository;
import com.example.cmisdemo.service.DictionaryService;
import com.example.cmisdemo.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DictionaryController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

  @Autowired RepositoryService repositoryService;

  @Autowired DictionaryService dictionaryService;

  @PostMapping("/repository/{repositoryId}/folders")
  Folder createType(@RequestBody Folder folder, @PathVariable String repositoryId)
      throws Exception {
    LOGGER.info(folder.toString());
    Repository repository = repositoryService.getRepository(repositoryId);
    return dictionaryService.createFolder(repository, folder);
  }
}
