package com.example.basic.controller;

import java.util.Map;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class prepController {
    
    @RequestMapping(value = "/req/data", method = RequestMethod.GET)
    public Map<String,Object> prep1(@RequestParam Map<String, Object> map){
        
        return map;
    }

}
