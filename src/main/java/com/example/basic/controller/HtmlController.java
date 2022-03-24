package com.example.basic.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.VO.Any;
import com.example.basic.model.Demo;
import com.example.basic.model.Night_Pharmacy;
import com.example.basic.repository.NightpRepository;

@Controller
public class HtmlController {

	@GetMapping("html/req1")
	public String req1(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
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
		mav.addObject("a", "😊");
		return mav;
	}

	@Autowired
	NightpRepository npr;

	@GetMapping("/html/night/{page}")
	public String nightp(@PathVariable("page") int page, Model model) {

		Sort sort = Sort.by(Sort.Direction.DESC, "name");

		Pageable p = PageRequest.of(page - 1, 5, sort);

		Page<Night_Pharmacy> result = npr.findAll(p);

		List<Night_Pharmacy> nightList = result.getContent();

		model.addAttribute("np", nightList);

		return "nightp";
	}

	@GetMapping("/html/kakao")
	public String kakao() {
		return "html/kakao";
	}
	
	@GetMapping("/html/kakaoT")
	public String kakaoT() {
		return "html/kakaoT";
	}

	@GetMapping("/html/naver")
	public String naver() {
		return "html/naver";
	}

	@GetMapping("/html/naverR")
	public String naverR() {
		return "html/naverR";
	}

}
