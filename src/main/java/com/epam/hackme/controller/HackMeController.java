package com.epam.hackme.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.hackme.common.HackMeConstants;
import com.epam.hackme.common.HackMeHelper;

@Controller
public class HackMeController {
	
	@RequestMapping(HackMeConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
		Arrays.asList(request.getCookies()).stream().forEach(e->{e.setMaxAge(0);response.addCookie(e);});
		return HackMeConstants.CHALLENGE_ZERO_VIEW;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_ZERO)
	public String hackall(HttpServletRequest request) {
		String username=request.getParameter(HackMeConstants.USERNAME);
		String password=request.getParameter(HackMeConstants.PASSWORD);
		if(username.equalsIgnoreCase(HackMeConstants.ADMIN)&&password.equalsIgnoreCase(HackMeConstants.ADMIN)) {
			return HackMeConstants.CHALLENGE_ALL_VIEW;
		}
		else {
			return HackMeConstants.CHALLENGE_ZERO_VIEW;
		}
	}
	@RequestMapping(HackMeConstants.CHALLENGE_THREE)
	@ResponseBody
	public String challenge3(HttpServletResponse response) {
		/*String key=HackMeHelper.generateRandomString(10);
		String password=HackMeHelper.generateRandomString(10);
		String encrytedPassword=HackMeHelper.convertPlainToCipher(password);
		CacheService.savePassword(key, password);
		response.addCookie(new Cookie(key, encrytedPassword));*/
		String password=Base64Utils.encodeToString(HackMeConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.getBytes());
		response.addCookie(new Cookie(HackMeConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_KEY, password));
		return password;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_THREE)
	@ResponseBody
	public String validateChallenge3(@RequestBody String password) {
		if(HackMeConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.CHALLENGE_TWO)
	public String challenge2(HttpServletResponse response) {
		response.addCookie(new Cookie(HackMeConstants.PLAIN_COOKIE, HackMeConstants.PLAIN_COOKIE_VALUE));
		return HackMeConstants.SUCCESS;
	}
	@RequestMapping(HackMeConstants.CHALLENGE_FOUR)
	public String challenge4(HttpServletResponse response) {
		String password=HackMeHelper.convertPlainToCipher(HackMeHelper.generateRandomString(10));
		response.addCookie(new Cookie(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, password));
		return HackMeConstants.SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_FOUR)
	@ResponseBody
	public String validateChallenge4(@RequestBody String password) {
		if(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_VALUE.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_FIVE)
	@ResponseBody
	public String validateChallenge5(@RequestBody String password) {
		if(HackMeConstants.CHALLENG5_PASSWORD.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_EIGHT)
	@ResponseBody
	public String validateChallenge8(HttpServletRequest request,HttpServletResponse response) {
		if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(HackMeConstants.ROLE_TYPE)&&e.getValue().equals(HackMeConstants.ADMIN_ROLE))) {
			return HackMeConstants.ADMIN_ROLE;
		}else if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(HackMeConstants.ROLE_TYPE)&&e.getValue().equals(HackMeConstants.USER_ROLE))) {
			return HackMeConstants.USER_ROLE;
		}
		response.addCookie(new Cookie(HackMeConstants.ROLE_TYPE, HackMeConstants.USER_ROLE));
		return HackMeConstants.USER_ROLE;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_NINE)
	@ResponseBody
	public String validateChallenge9(@RequestBody String command) throws IOException, InterruptedException {
		String output="";
		Process proc = Runtime.getRuntime().exec(command);
		int result = proc.waitFor();
		InputStream in = (result == 0) ? proc.getInputStream() : proc.getErrorStream();
		int c;
		while ((c = in.read()) != -1) {
			output=output+(char)c;
		}
		return output;
	}
}
