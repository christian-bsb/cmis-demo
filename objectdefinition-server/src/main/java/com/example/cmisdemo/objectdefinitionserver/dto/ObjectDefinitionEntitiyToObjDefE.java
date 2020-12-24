package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.PropertyDefinitionEntity;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionEntitiyToObjDefE {

  public ObjectDefinitionEntity objDefEToObjDefE(
      ObjectDefinitionEntity source, ObjectDefinitionEntity target) {
    System.out.println("*********** ObjectDefinitionEntity start");
    target.setName(source.getName());

    for (PropertyDefinitionEntity propDefES : source.getPropertyDefinitions()) {
      PropertyDefinitionEntity propDefET =
          target.getPropertyDefinitionById(propDefES.getPropertyId());
      if (propDefET != null) {
        System.out.println("*********** ObjectDefinitionEntity upd" + propDefES);
        propDefEToPropDefE(propDefES, propDefET);
      } else {
        System.out.println("*********** ObjectDefinitionEntity insert" + propDefES);
        PropertyDefinitionEntity newPropDefET = new PropertyDefinitionEntity();
        newPropDefET.setPropertyId(propDefES.getPropertyId());
        propDefEToPropDefE(propDefES, newPropDefET);
        target.addPropertyDefinition(newPropDefET);
      }
    }
    return target;
  }

  public PropertyDefinitionEntity propDefEToPropDefE(
      PropertyDefinitionEntity source, PropertyDefinitionEntity target) {
    target.setName(source.getName());
    target.setPropertyType(source.getPropertyType());
    target.setCardinality(source.getCardinality());
    return target;
  }
}
