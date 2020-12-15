package com.example.adminserver.controller;

import com.example.cmisdemo.model.*;
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
public class TypeController {

  @Autowired TypeDefinitionRepository typeDefinitionRepository;

  @Autowired DocumentRepository documentRepository;

  @GetMapping("/repository/{repositoryId}/type/{typeId}/edit")
  public String createForm(
      @PathVariable String repositoryId, @PathVariable String typeId, Model model)
      throws Exception {

    ObjectType objectType = new ObjectType();
    if (!"new".equals(typeId)) {
      objectType = typeDefinitionRepository.getTypeDefinition(typeId);
    }

    model.addAttribute("type", objectType);
    return "types";
  }

  @RequestMapping(value = "/saveType", method = RequestMethod.POST)
  public String saveBean(HttpServletRequest req) throws Exception {
    Map<String, String[]> parameterMap = req.getParameterMap();
    Document document = new Document();

    for (Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
      if ("id".equals(entry.getKey())) {
        PropertyDefinition iddef =
            new PropertyDefinition("id", "id", PropertyType.STRING, Cardinality.SINGLE);
        document.getProperties().add(new CmisProperty(iddef, entry.getValue()));
      }
    }

    documentRepository.createDocument(document);
    return "redirect:/repository/1/type/1/form";
  }
}
