package com.epam.hackme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.dto.User;
import com.epam.hackme.repository.HackMeDaoImpl;

@Controller
public class RegistrationController {
	
	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(CommonConstants.REGISTRATION)
	public ModelAndView registeration() {
		return new ModelAndView(CommonConstants.REGISTRATION_VIEW, "user", new User());
	}
	
	@RequestMapping(CommonConstants.REGISTRATION_USER)
	public ModelAndView registeruser(User user) {
		try {
		String registereduserid=dao.registerUser(user);
		if(registereduserid.equalsIgnoreCase(user.getUserid())) {
		return new ModelAndView(CommonConstants.USER_LOGIN, "userid",registereduserid);
		}else {
			return new ModelAndView(CommonConstants.REGISTRATION_VIEW, "error","Please enter valid details and click on register");
		}
		}catch(Exception e) {
			return new ModelAndView(CommonConstants.REGISTRATION_VIEW, "error","Please enter valid details and click on register");
		}
		}
}
