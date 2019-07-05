package com.epam.hackme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.dto.User;
import com.epam.hackme.service.HackMeService;

@Controller
public class LoginController {
	
	@Autowired
	private HackMeService service;
	
	@RequestMapping({CommonConstants.USER_LOGIN,CommonConstants.USER_LOGIN_DEFAULT})
	public String login(HttpServletRequest request,HttpServletResponse response) {
		HackMeHelper.clearCookies(request, response);
		return CommonConstants.USER_LOGIN_VIEW;
	}
	
	@RequestMapping(CommonConstants.VALIDATE_USER)
	public ModelAndView validateuser(User user,HttpServletRequest request) {
		return service.validateUser(user, request);
	}
	
	
}
