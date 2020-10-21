package com.example.cmisdemo.controller;

import com.example.cmisdemo.service.DocumentService;
import com.example.cmisdemo.service.RepositoryService;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

  @Autowired RepositoryService repositoryService;

  @Autowired DocumentService documentService;

  @PostMapping("/repository/{repositoryId}/folder/{folderId}")
  String createDocument(
      @PathVariable String repositoryId,
      @PathVariable String folderId,
      @RequestBody Properties properties)
      throws Exception {
    LOGGER.info(properties.toString());
    // Repository repository = repositoryService.getRepository(repositoryId);
    return documentService.createDocument(repositoryId, folderId, properties);
  }
}
