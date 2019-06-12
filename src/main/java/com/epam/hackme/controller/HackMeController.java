package com.epam.hackme.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HackMeController {
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping("challengelogin")
	public String challangelogin(HttpServletRequest request) {
		return "challengelogin";
	}
	@RequestMapping("validate")
	public String validate(HttpServletRequest request) {
		request.getSession().setAttribute("username", request.getParameter("username"));
		return "success";
	}
	
	@RequestMapping("hackall")
	public String hackall(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")) {
			return "hackall";
		}
		else {
			return "challengelogin";
		}
	}
	@RequestMapping("/challenge5")
	public String hello(HttpServletResponse response) {
		response.addCookie(new Cookie("foo", "bar"));
		return null;

	}
}
