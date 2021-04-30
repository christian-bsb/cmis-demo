package com.example.cmisdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Document {

  List<CmisProperty> properties = new ArrayList<>();

  public Document() {}

  @JsonIgnore
  public String getId() {
    return getPropertyValue("id");
  }

  @JsonIgnore
  public String getTypeId() {
    return getPropertyValue("typeId");
  }

  public Document(List<CmisProperty> properties) {
    this.properties = properties;
  }

  public List<CmisProperty> getProperties() {
    return properties;
  }

  public String getPropertyValue(String key) {
    if (key == null) {
      return null;
    }
    for (CmisProperty cmisProperty : properties) {
      if (key.equals(cmisProperty.getDefinition().propertyId)) {
        Object obj = cmisProperty.getValue();
        if (obj != null) {
          return obj.toString();
        } else {
          return null;
        }
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "Document{" + "properties=" + properties + '}';
  }
}
