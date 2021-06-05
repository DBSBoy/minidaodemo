package com.gk.minidaodemo.controller;

import com.gk.minidaodemo.Entity.city;
import com.gk.minidaodemo.dao.CityDao;
import org.jeecgframework.minidao.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("city")
public class citycontroller {
    @Autowired
    CityDao cityDao;

    //注解方式
    @GetMapping("/get")
    public List<Map<String,Object>> getCity(){
        List lc=cityDao.getList();
        System.out.println(lc);
        return lc;
    }


    //通过Id查询
    @PostMapping("/bId")
    public List<Map<String,Object>> getById(@Param("ID") Integer ID){
        List<Map<String,Object>> lc = cityDao.getById(ID);
        System.out.println(lc);
        return lc;
    }

    //分离方式根据城市编码查
    @PostMapping("/get3")
    public List<Map<String,Object>> getCity3(@RequestBody city city){
        List<Map<String,Object>> lc = cityDao.getByCountryCode(city.getCountryCode());
        return lc;
    }
    //测试从前端取值
    @PostMapping("/j")
    public city getJson(@RequestBody city city){
        System.out.println(city.toString());
        return city;
    }
    //传入条件查询
    @PostMapping("/QByParams")
    public List<Map<String,Object>> getByParams(@RequestBody city city){
        Map<String, Object> map = new HashMap<>();
        map.put("id",city.getID());
        List<Map<String,Object>> clist= cityDao.getByParams(map);
        return clist;
    }

    //sql分离
    @GetMapping("/gs")
    public List<Map<String,Object>> getInSql() {
        List lc = cityDao.getInotherSql();
        System.out.println(lc);
        return lc;
    }




}
