package oit.is.z0264.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;

import oit.is.z0264.kaizi.janken.model.Janken;
//import oit.is.z0264.kaizi.janken.model.Entry;
import oit.is.z0264.kaizi.janken.model.User;
import oit.is.z0264.kaizi.janken.model.UserMapper;
import oit.is.z0264.kaizi.janken.model.Match;
import oit.is.z0264.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {

  /*
   * @Autowired
   * private Entry entry;
   */

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  /*
   * @GetMapping("/janken")
   * public String janken() {
   * return "janken.html";
   * }
   */

  @GetMapping("/janken")
  @Transactional
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    // this.entry.addUser(loginUser);
    // model.addAttribute("entry", this.entry);
    model.addAttribute("user", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    return "janken.html";
  }

  /*
   * @GetMapping("/janken.html")
   * public String janken2() {
   * return "janken.html";
   * }
   */
  /*
   * @GetMapping("/hand_rock")
   * public String hand_rock(ModelMap model) {
   * Janken janken = new Janken("グー");
   * // model.addAttribute("entry", this.entry);
   * model.addAttribute("janken", janken);
   * return "match.html";
   * }
   *
   * @GetMapping("/hand_scissors")
   * public String hand_scissors(ModelMap model) {
   * Janken janken = new Janken("チョキ");
   * // model.addAttribute("entry", this.entry);
   * model.addAttribute("janken", janken);
   * return "match.html";
   * }
   *
   * @GetMapping("/hand_paper")
   * public String hand_paper(ModelMap model) {
   * Janken janken = new Janken("パー");
   * // model.addAttribute("entry", this.entry);
   * model.addAttribute("janken", janken);
   * return "match.html";
   * }
   */
  /*
   * @PostMapping("/janken")
   * public String janken(@RequestParam String name, ModelMap model) {
   * model.addAttribute("Name", name);
   * return "janken.html";
   * }
   */

  @GetMapping("/match")
  public String match(@RequestParam int id, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    model.addAttribute("user1", user1);
    model.addAttribute("user2", user2);
    return "match.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam int id, @RequestParam String hand, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    Janken janken = new Janken(hand);
    matchMapper.insertMatch(user1.getId(), user2.getId(), janken.getYourHand(), janken.getEnemyHand());
    model.addAttribute("user1", user1);
    model.addAttribute("user2", user2);
    model.addAttribute("janken", janken);
    return "match.html";
  }

}
