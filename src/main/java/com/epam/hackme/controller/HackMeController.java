package com.epam.hackme.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping("/challenge2")
	public String challenge2(HttpServletResponse response) {
		response.addCookie(new Cookie("alex", "alex1"));
		return "success";
	}
	@RequestMapping("/generateEncodePassword")
	public String generateEncodePassword(HttpServletResponse response) {
		String password=Base64Utils.encodeToString("hello".getBytes());
		response.addCookie(new Cookie("ensrcpwd", password));
		return "success";
		
	}
	@RequestMapping("/challenge3Password")
	public String challenge3Password(@RequestBody String password) {
		String result="wrong";
		if("hello".equals(password)) {
			result="success";
		}
		return result;
		
	}
}
