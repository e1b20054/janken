package oit.is.z0264.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT * from MatchInfo;")
  ArrayList<MatchInfo> selectAllMatchInfo();

  @Select("SELECT * from MatchInfo where isActive = true;")
  ArrayList<MatchInfo> selectMatchInfoByTrue();

  @Select("SELECT * from MatchInfo where isActive = true and user1 = #{user1} and user2 = #{user2};")
  ArrayList<MatchInfo> selectMatchInfoBytrueId(int user2, int user1);

  @Insert("INSERT INTO matchInfo (user1, user2, user1Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{isActive})")
  void insertMatchInfo(int user1, int user2, String user1Hand, boolean isActive);

  @Update("UPDATE matchInfo SET isActive = false WHERE isActive = true and user1 = #{user1} and user2 = #{user2} and user1Hand = #{user1Hand};")
  void updateByTrue(int user1, int user2, String user1Hand);

}
