package com.gk.minidaodemo.controller;

import com.gk.minidaodemo.Entity.city;
import com.gk.minidaodemo.Entity.user;
import com.gk.minidaodemo.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class usercontroller {
    @Autowired
    userDao userDao;
    @PostMapping("/u/i")
    public List<Map<String,Object>> insertlist(@RequestBody user user){
        Integer i=userDao.insert(user);
        if(i!=0){
            List<Map<String,Object>> lu = userDao.getAll();
            return lu;
        }else{
            return null;
        }
    }

}
