package com.example.cmisdemo.model;

import java.util.LinkedList;
import java.util.List;

public class ObjectType {

  String typeId = null;
  String displayName = "";
  List<PropertyDefinition> propertyDefinitions = new LinkedList<>();

  public ObjectType() {}

  public ObjectType(String id, String displayName) {
    this.typeId = id;
    this.displayName = displayName;
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
        + typeId
        + '\''
        + ", displayName='"
        + displayName
        + '\''
        + ", propertyDefinitions="
        + propertyDefinitions
        + '}';
  }
}
