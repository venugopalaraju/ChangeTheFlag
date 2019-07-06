package com.epam.hackme.validator;

import javax.servlet.http.HttpServletRequest;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.PasswordConstants;

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
}
