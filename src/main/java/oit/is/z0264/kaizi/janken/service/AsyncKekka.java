package oit.is.z0264.kaizi.janken.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0264.kaizi.janken.model.Match;
import oit.is.z0264.kaizi.janken.model.MatchMapper;
import oit.is.z0264.kaizi.janken.model.MatchInfo;

@Service
public class AsyncKekka {
  boolean dbUpdated = false;

  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);

  @Autowired
  MatchMapper matchMapper;

  public void syncInsertMatch(MatchInfo matchInfo, String hand) {
    matchMapper.insertMatch(matchInfo.getUser1(), matchInfo.getUser2(), matchInfo.getUser1Hand(), hand, true);
    this.dbUpdated = true;
  }

  public ArrayList<Match> syncShowMatch() {
    return matchMapper.selectMatchByTrue();
  }

  @Async
  public void asyncShowkekka(SseEmitter emitter) {
    logger.info("start connection");
    dbUpdated = true;
    try {
      while (true) {
        if (false == dbUpdated) {
          TimeUnit.MILLISECONDS.sleep(500);
          continue;
        }
        ArrayList<Match> matches = this.syncShowMatch();
        emitter.send(matches.get(0));
        TimeUnit.MILLISECONDS.sleep(1000);
        dbUpdated = false;
      }
    } catch (Exception e) {
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
    System.out.println("asyncShowkekka complete");
  }
}
