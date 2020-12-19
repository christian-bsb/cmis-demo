package com.example.adminserver.model;

import com.example.cmisdemo.model.PropertyDefinition;
import java.util.LinkedList;
import java.util.List;

public class TypeFormBean {

  String id = null;
  String displayName = "";
  List<PropertyDefinition> propertyDefinitions = new LinkedList<>();

  public TypeFormBean() {}

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
}
