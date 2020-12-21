package com.example.cmisdemo.objectdefinitionserver.model.hibernate;

import com.example.cmisdemo.model.Cardinality;
import com.example.cmisdemo.model.PropertyType;
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

  private PropertyType propertyType;

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
}
