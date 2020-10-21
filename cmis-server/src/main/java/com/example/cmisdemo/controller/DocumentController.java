package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.repository.Repository;
import com.example.cmisdemo.service.DictionaryService;
import com.example.cmisdemo.service.DocumentService;
import com.example.cmisdemo.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class DocumentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

  @Autowired
  RepositoryService repositoryService;

  @Autowired
  DocumentService documentService;

  @PostMapping("/repository/{repositoryId}/folder/{folderId}")
  Folder createDocument(@PathVariable String repositoryId, @RequestBody Properties properties ) throws Exception {
    LOGGER.info(folder.toString());
    Repository repository = repositoryService.getRepository(repositoryId);
    return documentService.createDocument( repository, folder);
  }

}
