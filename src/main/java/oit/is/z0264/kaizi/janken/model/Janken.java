package oit.is.z0264.kaizi.janken.model;

import java.util.Random;

public class Janken {
  String YourHand;
  String EnemyHand;
  String Result;

  public Janken(String Hand) {
    this.YourHand = Hand;
    Random rand = new Random();
    int num = rand.nextInt(3);
    if (num == 0) {
      this.EnemyHand = "グー";
      if (YourHand.equals("グー")) {
        this.Result = "Draw";
      } else if (YourHand.equals("チョキ")) {
        this.Result = "You Lose";
      } else {
        this.Result = "You Win!";
      }
    } else if (num == 1) {
      this.EnemyHand = "チョキ";
      if (YourHand.equals("グー")) {
        this.Result = "You Win!";
      } else if (YourHand.equals("チョキ")) {
        this.Result = "Draw";
      } else {
        this.Result = "You Lose";
      }
    } else {
      this.EnemyHand = "パー";
      if (YourHand.equals("グー")) {
        this.Result = "You Lose";
      } else if (YourHand.equals("チョキ")) {
        this.Result = "You Win!";
      } else {
        this.Result = "Draw";
      }
    }
  }

  public String getYourHand() {
    return this.YourHand;
  }

  public void setYourHand(String Hand) {
    this.YourHand = Hand;
  }

  public String getEnemyHand() {
    return this.EnemyHand;
  }

  public void setEnemyHand(String Hand) {
    this.EnemyHand = Hand;
  }

  public String getResult() {
    return this.Result;
  }

  public void setResult(String result) {
    this.Result = result;
  }
}
