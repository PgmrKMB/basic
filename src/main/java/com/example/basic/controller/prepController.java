package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.basic.VO.dataex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class prepController {
    
    
    @RequestMapping(value = "/req/data", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> prep1(@RequestParam Map<String, Object> map){  
        return map;
    }

    @GetMapping(value="/req/data2")
    @ResponseBody
    public Map<String, Object>  getMethodName(@ModelAttribute dataex de) {
        Map<String, Object> map = new HashMap<>();
        map.put("area", de.getArea());
        map.put("score", de.getScore());

        return map;
    }
    
    @GetMapping(value = "/req/data3")
    @ResponseBody
    public Map<String, Object> data(
        @RequestParam(value = "name"  , required = false) String area,
        @RequestParam(value = "age"  , required = false) String score,
        @ModelAttribute("data") dataex de) {
            Map<String,Object> map = new HashMap<>();

            if(area !=null){
                map.put("name", area);
            }
            if(score !=null){
                map.put("age", score);
            }
            return map;
        }
    
}
