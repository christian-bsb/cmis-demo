package com.example.docuserver.service;

import com.example.cmisdemo.model.Document;
import com.example.docuserver.dto.DtoService;
import com.example.docuserver.model.CmisDoc;
import com.example.docuserver.repository.CmisDocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

  @Autowired
  CmisDocRepository cmisDocRepository;

  @Autowired
  DtoService dtoService;

  public List<Document> getDocuments(){
    List<CmisDoc> cmisDocs = cmisDocRepository.getCmisDocs();
    return dtoService.cmisDocsToDocuments(cmisDocs);
  }
}