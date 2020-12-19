package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.PropertyDefinition;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.PropertyDefinitionEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionDto {

  public List<ObjectType> objDefEsToObjTypes(Iterable<ObjectDefinitionEntity> objDefEs) {
    List<ObjectType> objectTypes = new ArrayList<>();
    for (ObjectDefinitionEntity objDefE : objDefEs) {
      objectTypes.add(objDefEToObjType(objDefE));
    }
    return objectTypes;
  }

  public ObjectDefinitionEntity objTypeToObjDefE(ObjectType objectType) {
    ObjectDefinitionEntity objectDefinitionEntity = new ObjectDefinitionEntity();
    objectDefinitionEntity.setName(objectType.getDisplayName());
    objectDefinitionEntity.setPropertyDefinitions(
        propDefsToPropDefEs(objectType.getPropertyDefinitions(), objectDefinitionEntity));
    return objectDefinitionEntity;
  }

  public ObjectType objDefEToObjType(ObjectDefinitionEntity objDefE) {
    ObjectType objectType = new ObjectType();
    objectType.setId("" + objDefE.getId());
    objectType.setDisplayName(objDefE.getName());
    objectType.setPropertyDefinitions(propDefEsToPropDefs(objDefE.getPropertyDefinitions()));
    return objectType;
  }

  public List<PropertyDefinitionEntity> propDefsToPropDefEs(
      List<PropertyDefinition> propDefs, ObjectDefinitionEntity objDefE) {
    return propDefs.stream().map(x -> propDefToPropDefE(x, objDefE)).collect(Collectors.toList());
  }

  public List<PropertyDefinition> propDefEsToPropDefs(List<PropertyDefinitionEntity> propDefEs) {
    return propDefEs.stream().map(x -> propDefEToPropDef(x)).collect(Collectors.toList());
  }

  public PropertyDefinitionEntity propDefToPropDefE(
      PropertyDefinition propDef, ObjectDefinitionEntity objDefE) {
    PropertyDefinitionEntity propDefE = new PropertyDefinitionEntity();
    if (propDef.getId() != null) {
      propDefE.setId(Long.getLong(propDef.getId()));
    }
    propDefE.setName(propDef.getDisplayName());
    propDefE.setObjectDefinition(objDefE);
    propDefE.setCardinality(propDef.getCardinality());
    propDefE.setPropertyType(propDef.getPropertyType());
    return propDefE;
  }

  public PropertyDefinition propDefEToPropDef(PropertyDefinitionEntity propDefE) {
    PropertyDefinition propDef = new PropertyDefinition();
    propDef.setId("" + propDefE.getId());
    propDef.setDisplayName(propDefE.getName());
    propDef.setCardinality(propDefE.getCardinality());
    propDef.setPropertyType(propDefE.getPropertyType());
    return propDef;
  }
}
