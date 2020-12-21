package com.example.cmisdemo.model;

public class PropertyDefinition {

  String propertyId = "";
  String displayName = "";
  PropertyType propertyType = PropertyType.STRING;
  Cardinality cardinality = Cardinality.SINGLE;

  public PropertyDefinition() {}

  public PropertyDefinition(
      String id, String displayName, PropertyType propertyType, Cardinality cardinality) {
    this.propertyId = id;
    this.displayName = displayName;
    this.propertyType = propertyType;
    this.cardinality = cardinality;
  }

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(String propertyId) {
    this.propertyId = propertyId;
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
        + propertyId
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
