package com.example.docuserver.model;

public interface EagerPart {

  void setInstancePk(String instancePk);

  String getInstancePk();

  void loadLazyPart();

  String getStringRepresentation();
}
