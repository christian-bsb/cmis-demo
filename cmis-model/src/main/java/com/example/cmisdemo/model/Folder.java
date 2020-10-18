package com.example.cmisdemo.model;

import java.util.HashMap;
import java.util.Map;

public class Folder {

  String id;
  String name;
  Map<String, Object> properties = new HashMap<>();

  public Folder() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "Folder{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", properties="
        + properties
        + '}';
  }
}
