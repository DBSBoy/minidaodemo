package com.gk.minidaodemo.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gk.minidaodemo.Entity.city;
import com.gk.minidaodemo.dao.CityDao;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class cityExeService {
    @Autowired
    CityDao cityDao;

    public List SortCityPopulation(){
        List<Map<String,String>> cityList = cityDao.getCityList();
        List<String> clist = null;
        clist = cityList.stream().map(x->x.get("Population").toString()).collect(Collectors.toList());
        return clist;
    }
    // 直接远程或者数据库获取的对象类型集合，需要转换一次，如果是基本类型就不需要
    public List SortAndLimit(){
        // cityList元素类型在这里转为city类型，stram不一定认得出，需要再转一次
        List<city> cityList = cityDao.getCityList2();
        // 使用ObjectMapper转成json先，再转回对象
        ObjectMapper mapper = new ObjectMapper();
        List<city> list = mapper.convertValue(cityList, new TypeReference<List<city>>() { });
        List<Integer> clist = null;
        clist = list.stream().map(city::getPopulation).sorted((a,b)->{
            if(a>b){
                return 1;
            }else {
                return 0;
            }
        }).limit(10).collect(Collectors.toList());
        return clist;
    }
    // 短路操作,遇到符合情况的就终止操作，返回匹配的第一个，相似的还有anyMatch()，anyMatch()返回的是布尔值
    public String matchFirst(){
        List<city> cityList = cityDao.getCityList2();
        ObjectMapper mapper = new ObjectMapper();
        List<city> list = mapper.convertValue(cityList, new TypeReference<List<city>>() { });
        String matched = list.stream().map(city::getName).filter(s -> s.equals("Herat")).findFirst().get();
        return matched;
    }
    public Optional getByParams(Object object){
        // object转json对象
        String jsonStr = JSONObject.toJSONString(object);
        // json对象转jsonObject
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String code = (String) jsonObject.get("countryCode");
        List<city> cityList = cityDao.getCityList2();
        ObjectMapper mapper = new ObjectMapper();
        List<city> list = mapper.convertValue(cityList, new TypeReference<List<city>>() { });
        Optional<city> maxPopulationCity = list.stream()
                .filter(s->s.getCountryCode()
                .equals(code))
                .collect(Collectors
                .maxBy((c1,c2)->Integer.compare(c1.getPopulation(),c2.getPopulation())));
        return maxPopulationCity;
    }
}
