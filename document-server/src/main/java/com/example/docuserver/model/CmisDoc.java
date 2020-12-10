package com.example.docuserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "gettingstarted")
public class CmisDoc {

  @Id
  @Indexed
  private String id;

  public CmisDoc() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
