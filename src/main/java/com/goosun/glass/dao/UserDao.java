package com.goosun.glass.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.goosun.glass.domain.User;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM user where id=#{id} limit 1")
	public User get(Long id);
	
	@Select("SELECT * FROM user where username=#{username} limit 1")
	public User getByUsername(String username);
	
	@Insert("INSERT INTO user(username,password,title,type,point,coin,smallAvatar,mediumAvatar,largeAvatar,"
			+ "mobile,setup,roles,locked,loginTime,loginIp,loginSessionId,createdIp,createdTime) "
			+ "VALUES(#{username},#{password},#{title},#{type},#{point},#{coin},#{smallAvatar},#{mediumAvatar},#{largeAvatar},"
			+ "#{mobile},#{setup},#{roles},#{locked},#{loginTime},#{loginIp},#{loginSessionId},#{createdIp},#{createdTime,jdbcType=TIMESTAMP})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int addUser(User user);
	
	@Delete("delete from user where id=#{id} limit 1")
	public int delete(Long id);
	
	
}