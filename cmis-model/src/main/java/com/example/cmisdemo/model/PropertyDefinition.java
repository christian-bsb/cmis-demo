package com.example.cmisdemo.model;

public class PropertyDefinition {

  String propertyId = "";
  String displayName = "";
  String typeId = Constants.OBJECTTYPE_STRING;
  Cardinality cardinality = Cardinality.SINGLE;

  public PropertyDefinition() {}

  public PropertyDefinition(String id, String displayName, String typeId, Cardinality cardinality) {
    this.propertyId = id;
    this.displayName = displayName;
    this.typeId = typeId;
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

  public Cardinality getCardinality() {
    return cardinality;
  }

  public void setCardinality(Cardinality cardinality) {
    this.cardinality = cardinality;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }
}
