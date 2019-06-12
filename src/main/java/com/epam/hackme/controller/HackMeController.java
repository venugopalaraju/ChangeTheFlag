package com.epam.hackme.controller;

import javax.servlet.http.HttpServletRequest;

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
		System.out.println(request.getParameter("sso"));
		return "challengelogin";
	}
	@RequestMapping("validate")
	public String validate(HttpServletRequest request) {
		request.getSession().setAttribute("username", request.getParameter("username"));
		return "success";
	}
	
	@RequestMapping("hackall")
	public String hackall() {
		//request.getSession().setAttribute("username", request.getParameter("username"));
		return "hackall";
	}
}
