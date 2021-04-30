package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.Document;
import com.example.cmisdemo.service.DocumentService;
import com.example.cmisdemo.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

  @Autowired RepositoryService repositoryService;

  @Autowired DocumentService documentService;

  @PostMapping("/repository/{repositoryId}/folder/{folderId}/documents")
  String createDocument(
      @PathVariable String repositoryId,
      @PathVariable String folderId,
      @RequestBody Document document)
      throws Exception {
    LOGGER.info(document.toString());
    return documentService.createDocument(repositoryId, folderId, document);
  }

  @GetMapping(
      path = "/repository/{repositoryId}/document/{documentId}",
      produces = "application/json")
  public Document getDocument(@PathVariable String repositoryId, @PathVariable String documentId)
      throws Exception {
    Document document = documentService.getDocument(repositoryId, documentId);
    LOGGER.info(
        "getDocument repositoryId: "
            + repositoryId
            + " documentid: "
            + documentId
            + " "
            + document);
    return document;
  }
}
