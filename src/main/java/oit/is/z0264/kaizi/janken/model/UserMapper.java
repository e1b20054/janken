package oit.is.z0264.kaizi.janken.model;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * from Users;")
  ArrayList<User> selectAllUser();

}