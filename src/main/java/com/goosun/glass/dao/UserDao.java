package com.goosun.glass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.goosun.glass.domain.User;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM user ")
	public List<User> findUserInfo();
	
	@Insert("INSERT INTO user(name) VALUES(#{name})")
	public int addUserInfo(User user);
	
	@Delete("delete from user where id=#{id}")
	public int delUserInfo(int id);
}