package com.example.formsserver.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormBean implements Serializable {

  List<FormBeanProperty> properties = new ArrayList<>();

  public FormBean() {
    properties.add(new FormBeanProperty("id", ""));
    properties.add(new FormBeanProperty("name", ""));
    properties.add(new FormBeanProperty("kommentar", ""));
  }

  public List<FormBeanProperty> getProperties() {
    return properties;
  }

  @Override
  public String toString() {
    return "FormBean{" + "properties=" + properties + '}';
  }
}
