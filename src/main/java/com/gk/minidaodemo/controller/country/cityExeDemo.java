package com.gk.minidaodemo.controller.country;

import com.gk.minidaodemo.dao.CityDao;
import com.gk.minidaodemo.service.cityExeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("exe")
public class cityExeDemo {
    @Autowired
    cityExeService cityExeService;

    @GetMapping("getSort")
    public List getSort(){
        try {
            return cityExeService.SortCityPopulation();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("SortAndLimit")
    public List SortAndLimit(){
        try {
            return cityExeService.SortAndLimit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("matchFirst")
    public String matchFirst(){
        try {
            return cityExeService.matchFirst();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("getByParams")
    public Optional getByParams(@RequestBody Object obj){
        try {
            return cityExeService.getByParams(obj);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
