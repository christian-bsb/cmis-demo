package com.example.cmisdemo.model;

public class CmisProperty {

  PropertyDefinition definition;
  Object value;

  public CmisProperty() {}

  public CmisProperty(PropertyDefinition definition, Object value) {
    this.definition = definition;
    this.value = value;
  }

  public PropertyDefinition getDefinition() {
    return definition;
  }

  public void setDefinition(PropertyDefinition definition) {
    this.definition = definition;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "CmisProperty{" + "definition=" + definition + ", value=" + value + '}';
  }
}
