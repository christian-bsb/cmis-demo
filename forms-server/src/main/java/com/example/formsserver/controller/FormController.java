package com.example.formsserver.controller;

import com.example.cmisdemo.model.*;
import com.example.formsserver.model.FormBean;
import com.example.formsserver.model.FormBeanProperty;
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

  @GetMapping("/repository/{repositoryId}/type/{typeId}/form")
  public String createForm(
      @PathVariable String repositoryId, @PathVariable String typeId, Model model)
      throws Exception {

    ObjectType objectType = typeDefinitionRepository.getTypeDefinition(typeId);

    PropertyDefinition iddef =
        new PropertyDefinition("id", "id", PropertyType.STRING, Cardinality.SINGLE);
    Document document = new Document();
    document.getProperties().add(new CmisProperty(iddef, "id:777"));

    FormBean formBean = new FormBean();
    formBean.getProperties().add(new FormBeanProperty("id", ""));
    for (PropertyDefinition propertyDefinition : objectType.getPropertyDefinitions()) {
      formBean.getProperties().add(new FormBeanProperty(propertyDefinition.getDisplayName(), ""));
    }

    model.addAttribute("formBean", formBean);
    return "form";
  }

  @RequestMapping(value = "/saveBean", method = RequestMethod.POST)
  public String saveBean(HttpServletRequest req) {
    Map<String, String[]> parameterMap = req.getParameterMap();
    for (Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
    }

    return "redirect:/form";
  }
}
