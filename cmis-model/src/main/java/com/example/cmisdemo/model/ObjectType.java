package com.example.cmisdemo.model;

import java.util.LinkedList;
import java.util.List;

public class ObjectType {

  String id = null;
  String displayName = "";
  List<PropertyDefinition> propertyDefinitions = new LinkedList<>();

  public ObjectType() {}

  public ObjectType(String id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public List<PropertyDefinition> getPropertyDefinitions() {
    return propertyDefinitions;
  }

  public void setPropertyDefinitions(List<PropertyDefinition> propertyDefinitions) {
    this.propertyDefinitions = propertyDefinitions;
  }

  @Override
  public String toString() {
    return "ObjectType{"
        + "id='"
        + id
        + '\''
        + ", displayName='"
        + displayName
        + '\''
        + ", propertyDefinitions="
        + propertyDefinitions
        + '}';
  }
}
