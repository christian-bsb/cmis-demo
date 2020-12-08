package com.example.formsserver.model;

public class FormBeanProperty {

  String name;
  Object value;

  public FormBeanProperty() {}

  public FormBeanProperty(String name, Object value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "FormBeanProperty{" + "name='" + name + '\'' + ", value=" + value + '}';
  }
}
