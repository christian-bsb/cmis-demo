package com.example.docuserver.controller;

import com.example.cmisdemo.model.CmisProperty;
import com.example.cmisdemo.model.Document;
import com.example.docuserver.service.DocumentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoumentController {

  private static Logger LOGGER = LoggerFactory.getLogger(DoumentController.class);


  @Autowired
  DocumentService documentService;

  @PostMapping(
      path = "repository/{repositoryId}/document/insert",
      consumes = "application/json",
      produces = "application/json")
  public Document createObjectDefiniton(
      @PathVariable(value = "repositoryId") String repositoryId,
      @RequestBody Document document) {
    LOGGER.info("insert document {}", document.toString());

    return document;
  }

  @GetMapping(path = "/repository/{repositoryId}/document/{documentId}", produces = "application/json")
  public Document getDocument(
      @PathVariable String repositoryId, @PathVariable String documentId) {
    LOGGER.info("request rep: " + repositoryId + " type: " + documentId);
    return new Document();
  }

  @GetMapping(path = "/repository/{repositoryId}/documents", produces = "application/json")
  public List<Document> getDocuments(
      @PathVariable String repositoryId) {
    LOGGER.info("request rep: " + repositoryId );
    return documentService.getDocuments();
  }
}
