package com.gk.minidaodemo.dao;

import com.gk.minidaodemo.Entity.city;
import lombok.Data;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@MiniDao
public interface CityDao {
    @Arguments({"city"})
//    @Sql("select * from city")
    public List<Map<String,Object>>getAllCity(city city);

    @Sql("select * from city")
    List<Map<String,Object>> getList();

    @Sql("select * from city where ID = :ID")
    List<Map<String,Object>> getById(@Param("ID") Integer ID);

    int insert( @Param("city") city city);

    void delcity(@Param("ID")Integer ID);


    List<Map<String,Object>> getByCountryCode(@Param("code") String code);

    List<Map<String, Object>> getInotherSql();

    List<Map<String,Object>> getByParams(@Param("city") Map<String,Object> city);


}
