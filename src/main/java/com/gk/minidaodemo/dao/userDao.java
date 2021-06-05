package com.gk.minidaodemo.dao;

import com.gk.minidaodemo.Entity.user;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface userDao {
    @Sql("select * from user")
    List<Map<String,Object>> getAll();

    Integer insert(@Param("user")user user);
}
