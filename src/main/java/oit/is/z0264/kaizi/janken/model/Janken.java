package oit.is.z0264.kaizi.janken.model;

import java.util.Random;

public class Janken {
  String YourHand;
  String EnemyHand;
  String Result;
  static int matchCnt = 0;
  static int winCnt = 0;
  static int loseCnt = 0;
  static int drawCnt = 0;
  static int continueCnt = 0;

  public Janken(String Hand) {
    this.YourHand = Hand;
    Random rand = new Random();
    int num = rand.nextInt(3);
    if (num == 0) {
      this.EnemyHand = "Gu";
      if (YourHand.equals("Gu")) {
        this.Result = "Draw";
        drawCnt++;
        continueCnt = 0;
      } else if (YourHand.equals("Choki")) {
        this.Result = "You Lose";
        loseCnt++;
        continueCnt = 0;
      } else {
        this.Result = "You Win!";
        winCnt++;
        continueCnt++;
      }
    } else if (num == 1) {
      this.EnemyHand = "Choki";
      if (YourHand.equals("Gu")) {
        this.Result = "You Win!";
        winCnt++;
        continueCnt++;
      } else if (YourHand.equals("Choki")) {
        this.Result = "Draw";
        drawCnt++;
        continueCnt = 0;
      } else {
        this.Result = "You Lose";
        loseCnt++;
        continueCnt = 0;
      }
    } else {
      this.EnemyHand = "Pa";
      if (YourHand.equals("Gu")) {
        this.Result = "You Lose";
        loseCnt++;
        continueCnt = 0;
      } else if (YourHand.equals("Choki")) {
        this.Result = "You Win!";
        winCnt++;
        continueCnt++;
      } else {
        this.Result = "Draw";
        drawCnt++;
        continueCnt = 0;
      }
    }
    matchCnt++;
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

  public int getMatchCnt() {
    return matchCnt;
  }

  public void setMatchCnt(int n) {
    matchCnt = n;
  }

  public int getWinCnt() {
    return winCnt;
  }

  public void setWinCnt(int n) {
    winCnt = n;
  }

  public int getLoseCnt() {
    return loseCnt;
  }

  public void setLoseCnt(int n) {
    loseCnt = n;
  }

  public int getDrawCnt() {
    return drawCnt;
  }

  public void setDrawCnt(int n) {
    drawCnt = n;
  }

  public int getContinueCnt() {
    return continueCnt;
  }

  public void setContinueCnt(int n) {
    continueCnt = n;
  }
}
