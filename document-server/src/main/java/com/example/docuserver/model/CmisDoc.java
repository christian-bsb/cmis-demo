package com.example.docuserver.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "gettingstarted")
public class CmisDoc {

  @Id @Indexed private String id;

  @Indexed private String typeId;

  // private @Field("*_t") Map<String, List<String>> textMap;
  private @Field("*_t") Map<String, String> textMap = new HashMap<>();

  public CmisDoc() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public Map<String, String> getTextMap() {
    return textMap;
  }

  public void setTextMap(Map<String, String> textMap) {
    this.textMap = textMap;
  }
}
