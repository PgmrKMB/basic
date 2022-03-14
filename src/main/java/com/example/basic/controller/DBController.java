package com.example.basic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.basic.Dao.holiday_parkingDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class DBController {
    @Autowired
    JdbcTemplate jt;
    
    @Autowired
    holiday_parkingDAO hDao;

    //class 영역에 명령문(코드) 작성x
    // List list;
    // list.add(1);

    @GetMapping("/jdbc/demo")
    public List<Map<String, Object>> jdbcDemo() {
        
        //지역변수는 반드시 초기화 수행 후 활용
        // List<Integer> list = null;
        // list.add(1);
        // list.add("aa");
        
        return jt.queryForList("select * from demo");

    }
    
    
    @GetMapping("/jdbc/demo2")
    public Map<String, Object> jdbcDemo2() {
        return jt.queryForObject("select * from demo", Map.class);
    }
    
    @GetMapping("/jdbc/demo3")
    public Demos jdbcDemo3() {
        Demos demo = jt.queryForObject("select * from demo", Demos.class);
        return demo;
    }

    @GetMapping("/jdbc/holi")
    public List<Map<String, Object>> holi(@RequestParam(value = "page", defaultValue = "0") int page ){
        // return jt.queryForList("select * from holiday_parking where address like '%금천구%'");
        return hDao.select(page);
    }

}

@Data
class Demos {
    String user;
    int seq;
}