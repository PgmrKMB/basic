package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @GetMapping("req/param1")
    public String param1(
            @RequestParam("key1") String key1,
            @RequestParam("key2") String key2, 
            @RequestParam(value = "key3", defaultValue = "1") int key3) 
            {
        return key1 + ", " + key2+", "+ ++key3;
    }

    @GetMapping("req/param2")
    public String param2(@RequestParam Map<String, Object> map) {
        return map.toString();
    }


}
