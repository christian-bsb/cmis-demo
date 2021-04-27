package com.example.cmisdemo.objectdefinitionserver.model.hibernate;

import com.example.cmisdemo.model.Cardinality;
import com.example.cmisdemo.model.Constants;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_definition")
public class PropertyDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long pk;

  private String propertyId;

  private String name;

  String typeId = Constants.OBJECTTYPE_STRING;

  private Cardinality cardinality;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "obj_definition")
  private ObjectDefinitionEntity objectDefinition;

  public PropertyDefinitionEntity() {}

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(String propertyId) {
    this.propertyId = propertyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ObjectDefinitionEntity getObjectDefinition() {
    return objectDefinition;
  }

  public void setObjectDefinition(ObjectDefinitionEntity objectDefinition) {
    this.objectDefinition = objectDefinition;
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

  @Override
  public String toString() {
    return "PropertyDefinitionEntity{"
        + "propertyId='"
        + propertyId
        + '\''
        + ", name='"
        + name
        + '\''
        + '}';
  }
}
