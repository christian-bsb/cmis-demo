package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionEntitiyToObjDefE {

  public ObjectDefinitionEntity objDefEToObjDefE(
      ObjectDefinitionEntity source, ObjectDefinitionEntity target) {
    target.setName(source.getName());

    return target;
  }
}
