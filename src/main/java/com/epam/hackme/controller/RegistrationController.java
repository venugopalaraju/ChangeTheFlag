package com.epam.hackme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.dto.User;
import com.epam.hackme.repository.HackMeDaoImpl;
import com.epam.hackme.service.HackMeService;
import com.epam.hackme.validator.HackMeValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private HackMeService service;
	
	@RequestMapping(CommonConstants.REGISTRATION)
	public ModelAndView registeration() {
		return new ModelAndView(CommonConstants.REGISTRATION_VIEW, CommonConstants.USER, new User());
	}
	
	@RequestMapping(CommonConstants.REGISTRATION_USER)
	public ModelAndView registeruser(User user,ModelAndView mav) {
		if(HackMeValidator.validateUser(user,mav)) {
			return mav;
		}
		try {
			service.registerUser(user);
			return new ModelAndView(CommonConstants.USER_LOGIN, "userid", user.getUserid());
		} catch (Exception e) {
			return new ModelAndView(CommonConstants.REGISTRATION_VIEW, CommonConstants.ERROR,"Please enter valid details and click on register");
		}
		}
}
