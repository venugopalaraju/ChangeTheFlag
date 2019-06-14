package com.epam.hackme.controller;

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

@Controller
public class HackMeController {
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping(HackMeConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request) {
		return HackMeConstants.CHALLENGE_ZERO_VIEW;
	}
	/*@RequestMapping("validateChallenge0")
	public String validate(HttpServletRequest request) {
		request.getSession().setAttribute("username", request.getParameter("username"));
		return "success";
	}*/
	
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
		String password=Base64Utils.encodeToString(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_VALUE.getBytes());
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
}
