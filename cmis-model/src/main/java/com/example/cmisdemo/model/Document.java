package com.example.cmisdemo.model;

import java.util.List;

public class Document {

  List<CmisProperty> properties;

  public Document() {}

  public Document(List<CmisProperty> properties) {
    this.properties = properties;
  }

  public List<CmisProperty> getProperties() {
    return properties;
  }
}
