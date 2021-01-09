package com.example.formsserver.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class FormRepository {

  Map<String, String> formsMap = new HashMap<>();

  public FormRepository() {
    formsMap.put("person", "person");
  }

  public String getFormReference(String typeId) {
    if (formsMap.containsKey(typeId)) {
      return formsMap.get(typeId);
    } else {
      return "generic";
    }
  }
}
