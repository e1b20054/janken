package oit.is.z0264.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT * from MatchInfo;")
  ArrayList<MatchInfo> selectAllMatchInfo();

  @Insert("INSERT INTO matchInfo (user1, user2, user1Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{isActive})")
  void insertMatchInfo(int user1, int user2, String user1Hand, boolean isActive);

}
