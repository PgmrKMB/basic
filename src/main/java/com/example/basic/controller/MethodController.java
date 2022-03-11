package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {

    @GetMapping("req/get")
    public String get() {
        return "get";
    }

    @PostMapping("req/post")
    public String post() {
        return "POST";
    }

}
