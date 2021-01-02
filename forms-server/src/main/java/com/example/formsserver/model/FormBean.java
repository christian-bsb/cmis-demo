package com.example.formsserver.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormBean implements Serializable {

  String typeId;
  String displayName;
  List<FormBeanProperty> properties = new ArrayList<>();

  public FormBean() {
    // properties.add(new FormBeanProperty("id", ""));
    // properties.add(new FormBeanProperty("name", ""));
    // properties.add(new FormBeanProperty("kommentar", ""));
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public List<FormBeanProperty> getProperties() {
    return properties;
  }

  @Override
  public String toString() {
    return "FormBean{" + "properties=" + properties + '}';
  }
}
