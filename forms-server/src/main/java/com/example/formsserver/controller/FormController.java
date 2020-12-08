package com.example.formsserver.controller;

import com.example.formsserver.model.FormBean;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

  @GetMapping("/form")
  public String createForm(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("formBean", new FormBean());
    return "form";
  }

  /*
  @RequestMapping(value = "/saveBean", method = RequestMethod.POST)
  public String saveStudent(@ModelAttribute FormBean formBean, BindingResult errors, Model model) {
    System.out.println(formBean);
    return "form";
  }
  */

  @RequestMapping(value = "/saveBean", method = RequestMethod.POST)
  public String saveBean(HttpServletRequest req) {
    Map<String, String[]> parameterMap = req.getParameterMap();
    for (Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
    }

    return "redirect:/form";
  }
}
