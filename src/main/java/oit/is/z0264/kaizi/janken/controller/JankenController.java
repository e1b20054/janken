package oit.is.z0264.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0264.kaizi.janken.model.Janken;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @GetMapping("/janken.html")
  public String janken2() {
    return "janken.html";
  }

  @GetMapping("/hand_rock")
  public String hand_rock(ModelMap model) {
    Janken janken = new Janken("グー");
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  @GetMapping("/hand_scissors")
  public String hand_scissors(ModelMap model) {
    Janken janken = new Janken("チョキ");
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  @GetMapping("/hand_paper")
  public String hand_paper(ModelMap model) {
    Janken janken = new Janken("パー");
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    model.addAttribute("Name", name);
    return "janken.html";
  }

}
