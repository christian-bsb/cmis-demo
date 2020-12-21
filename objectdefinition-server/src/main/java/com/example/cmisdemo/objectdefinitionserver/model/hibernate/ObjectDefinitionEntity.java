package com.example.cmisdemo.objectdefinitionserver.model.hibernate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "obj_definition")
public class ObjectDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long pk;

  private String typeId;

  private String name;

  @OneToMany(mappedBy = "objectDefinition", cascade = CascadeType.ALL)
  List<PropertyDefinitionEntity> propertyDefinitions;

  public ObjectDefinitionEntity() {}

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PropertyDefinitionEntity> getPropertyDefinitions() {
    return propertyDefinitions;
  }

  public void setPropertyDefinitions(List<PropertyDefinitionEntity> propertyDefinitions) {
    this.propertyDefinitions = propertyDefinitions;
    for (PropertyDefinitionEntity prop : propertyDefinitions) {
      prop.setObjectDefinition(this);
    }
  }

  @Override
  public String toString() {
    return "ObjectDefinitionEntity{"
        + "id="
        + typeId
        + ", name='"
        + name
        + '\''
        + ", propertyDefinitions="
        + propertyDefinitions
        + '}';
  }
}
