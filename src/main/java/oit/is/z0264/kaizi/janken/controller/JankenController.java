package oit.is.z0264.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0264.kaizi.janken.model.User;
import oit.is.z0264.kaizi.janken.model.UserMapper;
import oit.is.z0264.kaizi.janken.service.AsyncKekka;
import oit.is.z0264.kaizi.janken.model.Match;
import oit.is.z0264.kaizi.janken.model.MatchMapper;
import oit.is.z0264.kaizi.janken.model.MatchInfo;
import oit.is.z0264.kaizi.janken.model.MatchInfoMapper;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  @Autowired
  AsyncKekka asyncKekka;

  @GetMapping("/janken")
  @Transactional
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    ArrayList<MatchInfo> matchInfo = matchInfoMapper.selectMatchInfoByTrue();
    model.addAttribute("user", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    model.addAttribute("matchInfo", matchInfo);
    return "janken.html";
  }

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
    ArrayList<MatchInfo> matchInfos = matchInfoMapper.selectMatchInfoBytrueId(user1.getId(), id);
    if (matchInfos.size() == 0) {
      matchInfoMapper.insertMatchInfo(user1.getId(), id, hand, true);
    } else if (matchInfos.size() == 1) {
      MatchInfo matchInfo = matchInfos.get(0);
      this.asyncKekka.syncInsertMatch(matchInfo, hand);
    }
    model.addAttribute("user", loginUser);
    return "wait.html";
  }

  @GetMapping("/janken/{param1}")
  @Transactional
  public String janken(@PathVariable int param1, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    Match match = matchMapper.selectMatchByID(param1);
    matchMapper.updateByTrue(param1);
    matchInfoMapper.updateByTrue(match.getUser1(), match.getUser2(), match.getUser1Hand());
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    ArrayList<MatchInfo> matchInfo = matchInfoMapper.selectMatchInfoByTrue();
    model.addAttribute("user", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    model.addAttribute("matchInfo", matchInfo);
    return "janken.html";
  }

  @GetMapping("/sse")
  public SseEmitter showKekka() {
    final SseEmitter sseEmitter = new SseEmitter();
    this.asyncKekka.asyncShowkekka(sseEmitter);
    return sseEmitter;
  }

}
