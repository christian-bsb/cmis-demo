package com.example.formsserver.controller;

import com.example.cmisdemo.model.*;
import com.example.formsserver.model.FormBean;
import com.example.formsserver.model.FormBeanProperty;
import example.com.cmisservices.repository.DocumentRepository;
import example.com.cmisservices.repository.TypeDefinitionRepository;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

  @Autowired TypeDefinitionRepository typeDefinitionRepository;

  @Autowired DocumentRepository documentRepository;

  @GetMapping("/repository/{repositoryId}/type/{typeId}/form")
  public String createForm(
      @PathVariable String repositoryId, @PathVariable String typeId, Model model)
      throws Exception {

    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);

    PropertyDefinition iddef =
        new PropertyDefinition("id", "id", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);
    Document document = new Document();
    document.getProperties().add(new CmisProperty(iddef, "id:777"));

    FormBean formBean = new FormBean();
    formBean.setTypeId(objectType.getTypeId());
    formBean.setDisplayName(objectType.getDisplayName());
    formBean.getProperties().add(new FormBeanProperty("id", ""));
    for (PropertyDefinition propertyDefinition : objectType.getPropertyDefinitions()) {
      formBean.getProperties().add(new FormBeanProperty(propertyDefinition.getPropertyId(), ""));
    }

    model.addAttribute("type", formBean);
    model.addAttribute("path", "/repository/" + repositoryId + "/type/" + typeId + "/instance");
    return "generic";
  }

  @GetMapping("/repository/{repositoryId}/document/{documentId}")
  public String editDocument(
      @PathVariable String repositoryId, @PathVariable String documentId, Model model)
      throws Exception {

    Document document = documentRepository.getDocument(repositoryId, documentId);
    // System.out.println("*********** " + document);

    String typeId = "book";
    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);

    PropertyDefinition iddef =
        new PropertyDefinition("id", "id", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);

    FormBean formBean = new FormBean();
    formBean.setTypeId(objectType.getTypeId());
    formBean.setDisplayName(objectType.getDisplayName());
    formBean.getProperties().add(new FormBeanProperty("id", ""));
    for (PropertyDefinition propertyDefinition : objectType.getPropertyDefinitions()) {
      formBean.getProperties().add(new FormBeanProperty(propertyDefinition.getPropertyId(), ""));
    }

    model.addAttribute("type", formBean);
    model.addAttribute("path", "/repository/" + repositoryId + "/type/" + typeId + "/instance");
    return "generic";
  }

  @RequestMapping(
      value = "/repository/{repositoryId}/type/{typeId}/instance",
      method = RequestMethod.POST)
  public String saveBean(
      @PathVariable String repositoryId, @PathVariable String typeId, HttpServletRequest req)
      throws Exception {
    Map<String, String[]> parameterMap = req.getParameterMap();
    System.out.println("****** " + parameterMap);
    Document document = new Document();

    PropertyDefinition propTypeId =
        new PropertyDefinition("typeId", "typeId", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);
    document.getProperties().add(new CmisProperty(propTypeId, typeId));

    for (Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
      PropertyDefinition propDef =
          new PropertyDefinition(
              entry.getKey(), entry.getKey(), Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);
      if (entry.getValue().length == 1) {
        document.getProperties().add(new CmisProperty(propDef, entry.getValue()[0]));
      }
    }

    documentRepository.createDocument(document);
    return "redirect:/repository/" + repositoryId + "/type/" + typeId + "/form";
  }
}
