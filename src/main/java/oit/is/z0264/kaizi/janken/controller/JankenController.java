package oit.is.z0264.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.transaction.annotation.Transactional;

import oit.is.z0264.kaizi.janken.model.Janken;
//import oit.is.z0264.kaizi.janken.model.Entry;
import oit.is.z0264.kaizi.janken.model.User;
import oit.is.z0264.kaizi.janken.model.UserMapper;

@Controller
public class JankenController {

  /*
   * @Autowired
   * private Entry entry;
   */

  @Autowired
  UserMapper userMapper;

  /*
   * @GetMapping("/janken")
   * public String janken() {
   * return "janken.html";
   * }
   */

  @GetMapping("/janken")
  // @Transactional
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    // this.entry.addUser(loginUser);
    // model.addAttribute("entry", this.entry);
    model.addAttribute("user", loginUser);
    model.addAttribute("users", users);
    return "janken.html";
  }

  /*
   * @GetMapping("/janken.html")
   * public String janken2() {
   * return "janken.html";
   * }
   */

  @GetMapping("/hand_rock")
  public String hand_rock(ModelMap model) {
    Janken janken = new Janken("グー");
    // model.addAttribute("entry", this.entry);
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  @GetMapping("/hand_scissors")
  public String hand_scissors(ModelMap model) {
    Janken janken = new Janken("チョキ");
    // model.addAttribute("entry", this.entry);
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  @GetMapping("/hand_paper")
  public String hand_paper(ModelMap model) {
    Janken janken = new Janken("パー");
    // model.addAttribute("entry", this.entry);
    model.addAttribute("janken", janken);
    return "janken.html";
  }

  /*
   * @PostMapping("/janken")
   * public String janken(@RequestParam String name, ModelMap model) {
   * model.addAttribute("Name", name);
   * return "janken.html";
   * }
   */

}
