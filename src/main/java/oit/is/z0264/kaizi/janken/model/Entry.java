package oit.is.z0264.kaizi.janken.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Entry {
  ArrayList<String> users = new ArrayList<>();
  int userCnt = 0;

  public void addUser(String name) {
    for (String s : this.users) {
      if (s.equals(name)) {
        return;
      }
    }
    this.users.add(name);
    userCnt++;
  }

  public int getUserCnt() {
    return userCnt;
  }

  public void setUserCnt(int cnt) {
    this.userCnt = cnt;
  }

  public ArrayList<String> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<String> users) {
    this.users = users;
  }

}
