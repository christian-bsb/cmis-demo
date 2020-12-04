package com.example.formsserver.controller;

import com.example.formsserver.model.FormBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

  @RequestMapping(value = "/saveBean", method = RequestMethod.POST)
  public String saveStudent(@ModelAttribute FormBean formBean, BindingResult errors, Model model) {
    System.out.println(formBean);
    return "form";
  }
}
