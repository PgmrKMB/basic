package com.example.basic.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.User;
import com.example.basic.repository.userRepository;

@Controller
public class SessionController {

	@GetMapping("/join")
	public String join() {
		return "join";
	}

	@Autowired
	userRepository usr;

	@PostMapping("/join")
	public String joinPost(@ModelAttribute User user) {
		usr.save(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute User user, HttpSession session) {

		User dbuser = usr.findByUserId(user.getUserId());
		System.out.println(dbuser);

		if(dbuser.getUserId() == user.getUserId()) {
		session.setAttribute("user", user);
		return "redirect:/main";
		}else {
		return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}

}
