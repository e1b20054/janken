package oit.is.z0264.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchMapper {

  @Select("SELECT * from Matches;")
  ArrayList<Match> selectAllMatch();

  @Select("SELECT * from Matches where user1 = #{user1} and user2 = #{user2} and user1Hand = #{user1Hand} and user2Hand = #{user2Hand};")
  Match selectMatchByKekka(int user1, int user2, String user1Hand, String user2Hand);

  @Select("SELECT * from Matches where id = #{id};")
  Match selectMatchByID(int id);

  @Select("SELECT * from Matches where isActive = true;")
  ArrayList<Match> selectMatchByTrue();

  @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{user2Hand}, #{isActive})")
  void insertMatch(int user1, int user2, String user1Hand, String user2Hand, boolean isActive);

  @Update("UPDATE matches SET isActive = false WHERE id = #{id}")
  void updateByTrue(int id);

}
