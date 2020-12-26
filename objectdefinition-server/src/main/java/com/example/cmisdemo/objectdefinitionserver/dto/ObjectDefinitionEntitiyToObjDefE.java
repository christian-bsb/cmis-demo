package com.example.cmisdemo.objectdefinitionserver.dto;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.model.hibernate.PropertyDefinitionEntity;
import com.example.cmisdemo.objectdefinitionserver.repository.PropertyDefinitionRepository;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectDefinitionEntitiyToObjDefE {

  @Autowired PropertyDefinitionRepository propertyDefinitionRepository;

  public ObjectDefinitionEntity objDefEToObjDefE(
      ObjectDefinitionEntity source, ObjectDefinitionEntity target) {
    System.out.println("*********** ObjectDefinitionEntity start");
    target.setName(source.getName());

    // check the new props
    for (PropertyDefinitionEntity propDefES : source.getPropertyDefinitions()) {
      PropertyDefinitionEntity propDefET =
          target.getPropertyDefinitionById(propDefES.getPropertyId());
      if (propDefET != null) {
        System.out.println("*********** ObjectDefinitionEntity upd " + propDefES);
        propDefEToPropDefE(propDefES, propDefET);
      } else {
        System.out.println("*********** ObjectDefinitionEntity insert " + propDefES);
        PropertyDefinitionEntity newPropDefET = new PropertyDefinitionEntity();
        newPropDefET.setPropertyId(propDefES.getPropertyId());
        propDefEToPropDefE(propDefES, newPropDefET);
        target.addPropertyDefinition(newPropDefET);
      }
    }

    // now check the old props
    Iterator<PropertyDefinitionEntity> iterator = target.getPropertyDefinitions().listIterator();
    // r (PropertyDefinitionEntity propDefET : target.getPropertyDefinitions()) {
    while (iterator.hasNext()) {
      PropertyDefinitionEntity propDefET = iterator.next();
      PropertyDefinitionEntity propDefES =
          source.getPropertyDefinitionById(propDefET.getPropertyId());
      if (propDefES == null) {
        System.out.println("*********** ObjectDefinitionEntity delete " + propDefET);
        // target.getPropertyDefinitions().remove(propDefET);
        // todo fix this bulshit with rest api
        iterator.remove();
        propertyDefinitionRepository.delete(propDefET);
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
