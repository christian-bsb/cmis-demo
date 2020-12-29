package com.example.adminserver.controller;

import com.example.adminserver.model.TypeFormBean;
import com.example.cmisdemo.model.*;
import example.com.cmisservices.repository.TypeDefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);

  @Autowired TypeDefinitionRepository typeDefinitionRepository;

  @GetMapping("/repository/{repositoryId}/type/insert")
  public String createType(@PathVariable String repositoryId, Model model) throws Exception {

    TypeFormBean typeFormBean = new TypeFormBean();
    return "newtype";
  }

  @GetMapping("/repository/{repositoryId}/type/{typeId}/update")
  public String updateType(
      @PathVariable String repositoryId, @PathVariable String typeId, Model model)
      throws Exception {

    TypeFormBean typeFormBean = new TypeFormBean();
    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);
    typeFormBean.setId(objectType.getTypeId());
    typeFormBean.setDisplayName(objectType.getDisplayName());
    for (PropertyDefinition propertyDefinition : objectType.getPropertyDefinitions()) {
      typeFormBean.getPropertyDefinitions().add(propertyDefinition);
    }

    model.addAttribute("type", typeFormBean);
    model.addAttribute("repositoryId", repositoryId);
    model.addAttribute(
        "updatePath", "/repository/" + repositoryId + "/type/" + typeId + "/property/update");
    model.addAttribute(
        "deletePath", "/repository/" + repositoryId + "/type/" + typeId + "/property/delete");
    model.addAttribute("typeId", typeId);

    return "properties";
  }

  @RequestMapping(value = "/newtype2", method = RequestMethod.GET)
  public String newType2(@RequestParam String id, @RequestParam String dn) throws Exception {

    ObjectType objectType = new ObjectType();
    objectType.setTypeId(id);
    objectType.setDisplayName(dn);
    typeDefinitionRepository.createType(objectType);

    return "newtype";
  }

  @RequestMapping(
      value = "/repository/{repositoryId}/type/{typeId}/property/update",
      method = RequestMethod.GET)
  public String addProperty(
      @PathVariable String repositoryId,
      @PathVariable String typeId,
      @RequestParam String id,
      @RequestParam String displayname,
      Model model)
      throws Exception {

    LOGGER.info("repository: update " + repositoryId + "type: " + typeId + " add property: " + id);

    model.addAttribute("repositoryId", repositoryId);
    model.addAttribute("typeId", typeId);

    TypeFormBean typeFormBean = new TypeFormBean();
    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);
    if (objectType != null) {
      objectType
          .getPropertyDefinitions()
          .add(new PropertyDefinition(id, displayname, PropertyType.STRING, Cardinality.SINGLE));
      typeDefinitionRepository.updateType(objectType);
    }

    model.addAttribute("type", typeFormBean);

    // return "redirect:/repository/" + repositoryId + "/type/" + typeId + "/update";
    return "properties";
  }

  @RequestMapping(
      value = "/repository/{repositoryId}/type/{typeId}/property/delete",
      method = RequestMethod.GET)
  public String deleteProperty(
      @PathVariable String repositoryId,
      @PathVariable String typeId,
      @RequestParam String id,
      @RequestParam String displayname,
      Model model)
      throws Exception {

    LOGGER.info(
        "repository: delete " + repositoryId + "type: " + typeId + " delerte property: " + id);

    model.addAttribute("repositoryId", repositoryId);
    model.addAttribute("typeId", typeId);

    TypeFormBean typeFormBean = new TypeFormBean();
    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);
    if (objectType != null) {
      for (int idx = 0; idx < objectType.getPropertyDefinitions().size(); idx++) {
        if (objectType.getPropertyDefinitions().get(idx).getPropertyId().equals(id)) {
          objectType.getPropertyDefinitions().remove(idx);
        }
      }
      typeDefinitionRepository.updateType(objectType);
    }

    model.addAttribute("type", typeFormBean);
    return "properties";
  }
}
