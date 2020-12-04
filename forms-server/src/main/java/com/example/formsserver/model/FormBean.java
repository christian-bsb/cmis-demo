package com.example.formsserver.model;

import java.io.Serializable;

public class FormBean implements Serializable {

  String id;
  String name;

  public FormBean() {}

  public FormBean(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
