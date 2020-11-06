package com.example.cmisdemo.model;

public class PropertyDefinition {

  String id;
  String displayName;
  PropertyType propertyType;
  Cardinality cardinality;

  public PropertyDefinition() {}

  public PropertyDefinition(
      String id, String displayName, PropertyType propertyType, Cardinality cardinality) {
    this.id = id;
    this.displayName = displayName;
    this.propertyType = propertyType;
    this.cardinality = cardinality;
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

  public PropertyType getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(PropertyType propertyType) {
    this.propertyType = propertyType;
  }

  public Cardinality getCardinality() {
    return cardinality;
  }

  public void setCardinality(Cardinality cardinality) {
    this.cardinality = cardinality;
  }

  @Override
  public String toString() {
    return "PropertyDefinition{"
        + "id='"
        + id
        + '\''
        + ", displayName='"
        + displayName
        + '\''
        + ", propertyType="
        + propertyType
        + ", cardinality="
        + cardinality
        + '}';
  }
}
