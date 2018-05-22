package com.goosun.glass.dao.user;

import com.goosun.glass.domain.PersistentLogin;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface PersistentTokenDao {

    @Insert("INSERT INTO persistent_logins(series,username,token,last_used) "
            + "VALUES(#{series},#{username},#{token},#{lastUsed,jdbcType=TIMESTAMP})")
    public void add(PersistentLogin persistentLogin);

    @Update("UPDATE persistent_logins SET token=#{token},last_used=#{lastUsed,jdbcType=TIMESTAMP} WHERE series=#{series} limit 1")
    public void update(PersistentLogin persistentLogin);

    @Results(id = "persistent_logins", value = {
            @Result(property = "series", column = "series"),
            @Result(property = "username", column = "username"),
            @Result(property = "token", column = "token"),
            @Result(property = "lastUsed", column = "last_used")
            })
    @Select("SELECT * FROM persistent_logins WHERE series=#{seriesId} limit 1")
    public PersistentLogin getBySeries(String seriesId);

    @Delete("DELETE FROM persistent_logins WHERE username=#{username}")
    public void remove(String username);

}
