package com.epam.hackme.common;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.dto.UserScore;

public class HackMeHelper {
	

public static String generateRandomString(int size) {
	return RandomStringUtils.random(size);
}

public static String convertPlainToCipher(String plainText) {
	return Base64Utils.encodeToString(plainText.getBytes());
}

public static String getCookieValue(HttpServletRequest request, String cookie) {
	return Arrays.stream(request.getCookies()).filter(c -> cookie.equals(c.getName())).map(Cookie::getValue).findAny().get();
}

public static String getUserId(HttpServletRequest request) {
	HttpSession session=request.getSession();
	return (String) session.getAttribute(CommonConstants.USER_ID);
}

public static String getMyScore(UserScore score) {
	StringBuilder scoreBoard=new StringBuilder();
		scoreBoard.append(CommonConstants.MYSCORE_TR_1);
		scoreBoard.append(score.getUserid());
		scoreBoard.append(CommonConstants.MYSCORE_TR_2);
		scoreBoard.append(score.getUserName());
		scoreBoard.append(CommonConstants.MYSCORE_TR_3);
		scoreBoard.append(score.getScore());
		scoreBoard.append(CommonConstants.MYSCORE_TR_4);
		return scoreBoard.toString();
}

public static void clearCookies(HttpServletRequest request,HttpServletResponse response) {
	if(request.getCookies()!=null) {
		Arrays.asList(request.getCookies()).stream().forEach(e->{e.setMaxAge(0);response.addCookie(e);});
	}
}

public static void prepareNextViewName(int challenge,ModelAndView mav) {
	switch(challenge) {
	case 1:
		mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
		break;
	case 2:
		mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
		break;
	case 3:
		mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
		break;
	case 4:
		mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
		break;
	case 5:
		mav.setViewName(CommonConstants.CHALLENGE_ZERO_VIEW);
		break;
		}
}

public static void prepareSameViewName(int challenge,ModelAndView mav) {
	switch(challenge) {
	case 1:
		mav.setViewName(CommonConstants.TRIVIA_ONE_VIEW);
		break;
	case 2:
		mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
		break;
	case 3:
		mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
		break;
	case 4:
		mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
		break;
	case 5:
		mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
		break;
		}
}

}
