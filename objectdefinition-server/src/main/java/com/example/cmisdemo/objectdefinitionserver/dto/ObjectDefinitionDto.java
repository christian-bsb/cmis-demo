package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.PropertyDefinition;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.PropertyDefinitionEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionDto {

  public ObjectDefinitionEntity objTypeToObjDefE(ObjectType objectType) {
    ObjectDefinitionEntity objectDefinitionEntity = new ObjectDefinitionEntity();
    objectDefinitionEntity.setName(objectType.getDisplayName());
    objectDefinitionEntity.setPropertyDefinitions(
        propDefsToPropDefEs(objectType.getPropertyDefinitions(), objectDefinitionEntity));
    return objectDefinitionEntity;
  }

  public ObjectType objDefEToObjType(ObjectDefinitionEntity objectDefinitionEntity) {
    ObjectType objectType = new ObjectType();
    objectType.setDisplayName(objectDefinitionEntity.getName());
    return objectType;
  }

  public List<PropertyDefinitionEntity> propDefsToPropDefEs(
      List<PropertyDefinition> propDefs, ObjectDefinitionEntity objDefE) {
    return propDefs.stream().map(x -> propDefToPropDefE(x, objDefE)).collect(Collectors.toList());
  }

  public PropertyDefinitionEntity propDefToPropDefE(
      PropertyDefinition propDef, ObjectDefinitionEntity objDefE) {
    PropertyDefinitionEntity propDefE = new PropertyDefinitionEntity();
    if (propDef.getId() != null) {
      propDefE.setId(Long.getLong(propDef.getId()));
    }
    propDefE.setName(propDef.getDisplayName());
    propDefE.setObjectDefinition(objDefE);
    return propDefE;
  }
}
