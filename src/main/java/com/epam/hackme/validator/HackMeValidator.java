package com.epam.hackme.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.User;

public class HackMeValidator {

	public static boolean validateChallengeZero(HttpServletRequest request) {
		String username=request.getParameter(CommonConstants.USERNAME);
		String password=request.getParameter(CommonConstants.PASSWORD);
		if(CommonConstants.ADMIN.equalsIgnoreCase(username)&&CommonConstants.ADMIN.equalsIgnoreCase(password)) {
			return true;
		}
		return false;
		
	}
	
	public static boolean isCorrectAnswer(String answer,int challenge) {
		switch(challenge) {
		case 1:
			return PasswordConstants.TRIVIA_ANSWER_ONE.equalsIgnoreCase(answer)||PasswordConstants.TRIVIA_ANSWER_ONE_1.equalsIgnoreCase(answer);
		case 2:
			return PasswordConstants.TRIVIA_ANSWER_TWO.equalsIgnoreCase(answer);
		case 3:
			return PasswordConstants.TRIVIA_ANSWER_THREE.equalsIgnoreCase(answer);
		case 4:
			return PasswordConstants.TRIVIA_ANSWER_FOUR.equalsIgnoreCase(answer);
		case 5:
			return PasswordConstants.TRIVIA_ANSWER_FIVE.equalsIgnoreCase(answer);
			}
		return false;
		
	}
	
	public static boolean validateUser(User user,ModelAndView mav) {
		if(user.getUserid().isEmpty()||user.getUsername().isEmpty()||user.getPassword().isEmpty()||user.getEmail().isEmpty()) {
			mav.setViewName(CommonConstants.REGISTRATION_VIEW);
			mav.addObject(CommonConstants.ERROR,"Please enter valid details and click on register");
			return true;
		}
		if(!user.getUsername().matches("^[a-zA-Z0-9]+$")) { 
			mav.setViewName(CommonConstants.REGISTRATION_VIEW);
			mav.addObject(CommonConstants.ERROR,"Oh! Please No XSS attacks here!");
			return true;
		}if(!user.getUserid().matches("\\d+")) {
			mav.setViewName(CommonConstants.REGISTRATION_VIEW);
			mav.addObject(CommonConstants.ERROR,"User Id should be a numeric value");
			 return true;
		}if(!user.getEmail().matches("^[A-Za-z0-9+_]+@+[A-Za-z0-9+_]+.+[A-Za-z0-9+_]$")) {
			mav.setViewName(CommonConstants.REGISTRATION_VIEW);
			mav.addObject(CommonConstants.ERROR,"Please Enter Valid Email Address Only!");
			 return true;
		}if(user.getPassword().length()>8) {
			mav.setViewName(CommonConstants.REGISTRATION_VIEW);
			mav.addObject(CommonConstants.ERROR,"Password Length Should Not Be More Than 8 Characters");
			 return true;
		}
				return false;
		
	}
}
