package com.example.cmisdemo.objectdefinitionserver.model.hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_definiton")
public class PropertyDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "object_definition")
  private ObjectDefinitionEntity objectDefinition;

  public PropertyDefinitionEntity() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
