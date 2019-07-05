package com.epam.hackme.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Base64Utils;

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

public static String getScoreBoard(List<UserScore> scores,String userId) {
	StringBuilder scoreBoard=new StringBuilder();
	scores.forEach(e->{
		if(e.getUserid().equalsIgnoreCase(userId)) {
			scoreBoard.append("<tr style='color:blue;'><td>");
			scoreBoard.append(e.getUserid());
			scoreBoard.append("</td><td>");
			scoreBoard.append(e.getUserName());
			scoreBoard.append("</td><td>");
			scoreBoard.append(e.getScore());
			scoreBoard.append("</td></tr>");
		}else {
			scoreBoard.append("<tr><td>");
			scoreBoard.append(e.getUserid());
			scoreBoard.append("</td><td>");
			scoreBoard.append(e.getUserName());
			scoreBoard.append("</td><td>");
			scoreBoard.append(e.getScore());
			scoreBoard.append("</td></tr>");
		}
	});
	return scoreBoard.toString();
	
}

public static String getMyScore(UserScore score) {
	StringBuilder scoreBoard=new StringBuilder();
		scoreBoard.append("<tr><td>");
		scoreBoard.append("User Id ");
		scoreBoard.append("</td><td>");
		scoreBoard.append(score.getUserid());
		scoreBoard.append("</td></tr><tr><td>");
		scoreBoard.append("Username ");
		scoreBoard.append("</td><td>");
		scoreBoard.append(score.getUserName());
		scoreBoard.append("</td></tr><tr><td>");
		scoreBoard.append("Score ");
		scoreBoard.append("</td><td>");
		scoreBoard.append(score.getScore());
		scoreBoard.append("</td></tr>");
	return scoreBoard.toString();
	
}

public static void clearCookies(HttpServletRequest request,HttpServletResponse response) {
	if(request.getCookies()!=null) {
		Arrays.asList(request.getCookies()).stream().forEach(e->{e.setMaxAge(0);response.addCookie(e);});
	}
}

public static String ConvertToMd5(String value) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(value.getBytes());
	byte[] digest = md.digest();
	StringBuffer sb = new StringBuffer();
	for (byte b : digest) {
		sb.append(String.format("%02x", b & 0xff));
	}
	return sb.toString();
}
}
