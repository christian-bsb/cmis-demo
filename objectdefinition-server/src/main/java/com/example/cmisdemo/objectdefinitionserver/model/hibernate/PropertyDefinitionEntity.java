package com.example.cmisdemo.objectdefinitionserver.model.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "object_definition")
public class PropertyDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String objectDefinition;


  public PropertyDefinitionEntity() {
  }

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

  public String getObjectDefinition() {
    return objectDefinition;
  }

  public void setObjectDefinition(String objectDefinition) {
    this.objectDefinition = objectDefinition;
  }
}
