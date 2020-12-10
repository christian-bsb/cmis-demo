package com.example.cmisdemo.service;

import com.example.cmisdemo.model.Document;
import example.com.cmisservices.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

  @Autowired DocumentRepository documentRepository;

  public String createDocument(String repositoryId, String folderId, Document document)
      throws Exception {
    return documentRepository.createDocument(document);
  }
}
