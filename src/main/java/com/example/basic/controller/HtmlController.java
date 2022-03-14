package com.example.basic.controller;

import java.util.Random;

import com.example.basic.VO.Any;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {
    
    @GetMapping("html/req1")
    public String req1(@RequestParam("name") String name,
                       @RequestParam("age") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "html/req1";
    }
    
    @GetMapping("html/req2")
    public String req2(@ModelAttribute("any") Any any) {
        
        return "html/req2";
    }


    @GetMapping("/")
    public String home(Model md) {
        md.addAttribute("num", new Random().nextInt(10));

        return "html/string";
    }

    @GetMapping("html/exam")
    public String exam() {
        return "html/exam";
    }


    @GetMapping("html/void")
    public void htmlVoid() {
    
    }

    @GetMapping("html/model_and_view")
    public ModelAndView htmlModel() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/model_and_view");
        mav.addObject("a","😊");
        return mav;
    }

}
