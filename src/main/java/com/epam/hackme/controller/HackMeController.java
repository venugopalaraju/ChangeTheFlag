package com.epam.hackme.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CacheService;
import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.dto.User;
import com.epam.hackme.repository.HackMeDaoImpl;

@Controller
public class HackMeController {
	
	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(CommonConstants.USER_LOGIN)
	public String login() {
		return CommonConstants.USER_LOGIN_VIEW;
	}
	@RequestMapping(CommonConstants.VALIDATE_USER)
	public ModelAndView validateuser(User user,HttpServletResponse response) {
		if(dao.isValidUser(user)) {
			response.addCookie(new Cookie(CommonConstants.USER_ID, user.getUserid()));
			return new ModelAndView(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
		return new ModelAndView(CommonConstants.USER_LOGIN_VIEW, "error","Please enter valid Credentials");
	}
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
	@RequestMapping(CommonConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ZERO)
	public String hackall(HttpServletRequest request) {
		String username=request.getParameter(CommonConstants.USERNAME);
		String password=request.getParameter(CommonConstants.PASSWORD);
		if(username.equalsIgnoreCase(CommonConstants.ADMIN)&&password.equalsIgnoreCase(CommonConstants.ADMIN)) {
			return CommonConstants.CHALLENGE_ALL_VIEW;
		}
		else {
			return CommonConstants.CHALLENGE_ZERO_VIEW;
		}
	}
	@RequestMapping(CommonConstants.CHALLENGE_TWO)
	public String challenge2(HttpServletRequest request,HttpServletResponse response) {
		dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),1);
		response.addCookie(new Cookie(CommonConstants.PLAIN_COOKIE, CommonConstants.PLAIN_COOKIE_VALUE));
		return CommonConstants.SUCCESS;
	}
	@RequestMapping(CommonConstants.CHALLENGE_THREE)
	@ResponseBody
	public String challenge3(HttpServletRequest request,HttpServletResponse response) {
		dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),2);
		/*String key=HackMeHelper.generateRandomString(10);
		String password=HackMeHelper.generateRandomString(10);
		String encrytedPassword=HackMeHelper.convertPlainToCipher(password);
		CacheService.savePassword(key, password);
		response.addCookie(new Cookie(key, encrytedPassword));*/
		String password=Base64Utils.encodeToString(CommonConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.getBytes());
		response.addCookie(new Cookie(CommonConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_KEY, password));
		return password;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_THREE)
	@ResponseBody
	public String validateChallenge3(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),3);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	
	@RequestMapping(CommonConstants.CHALLENGE_FOUR)
	@ResponseBody
	public String challenge4(HttpServletResponse response) {
		String password=HackMeHelper.convertPlainToCipher(HackMeHelper.generateRandomString(10));
		response.addCookie(new Cookie(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, Base64Utils.encodeToString(password.getBytes())));
		CacheService.savePassword(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, password);
		return CommonConstants.SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FOUR)
	@ResponseBody
	public String validateChallenge4(@RequestBody String password,HttpServletRequest request) {
		if(CacheService.getPassword(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY).equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),4);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FIVE)
	@ResponseBody
	public String validateChallenge5(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.CHALLENG_5_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),5);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_SIX)
	@ResponseBody
	public String validateChallenge6(HttpServletRequest request,HttpServletResponse response) {
		if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(CommonConstants.ROLE_TYPE)&&e.getValue().equals(CommonConstants.ADMIN_ROLE))) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),6);
			return CommonConstants.ADMIN_ROLE;
		}else if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(CommonConstants.ROLE_TYPE)&&e.getValue().equals(CommonConstants.USER_ROLE))) {
			return CommonConstants.USER_ROLE;
		}
		response.addCookie(new Cookie(CommonConstants.ROLE_TYPE, CommonConstants.USER_ROLE));
		return CommonConstants.USER_ROLE;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_EIGHT)
	@ResponseBody
	public String validateChallenge8(@RequestBody String password,HttpServletRequest request) throws IOException, InterruptedException {
		if(CommonConstants.CHALLENG_8_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),8);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_NINE)
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
	@RequestMapping(CommonConstants.CHALLENGE_TEN)
	@ResponseBody
	public String challange10username(String getvalue)  {
		if(getvalue.equals(CommonConstants.USERNAME)) {
			return CommonConstants.ADMIN;
		}else if(getvalue.equals(CommonConstants.PASSWORD)){
			return CommonConstants.CHALLANGE_10_PASSWORD;
		}
		return CommonConstants.INVALID_URL;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TEN)
	@ResponseBody
	public String validateChallenge10(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.CHALLANGE_10_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),10);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.CHALLENGE_ELEVEN)
	public String challange11login() {
		return CommonConstants.CHALLENGE_ELEVEN_VIEW;
	}
	@RequestMapping(CommonConstants.CHALLENGE_ELEVEN_ADMIN)
	@ResponseBody
	public String challange11admin() {
		return CommonConstants.CHALLENGE_ELEVEN_PASSWORD;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ELEVEN)
	@ResponseBody
	public String validateChallenge11(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.CHALLENGE_ELEVEN_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),11);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TWELVE)
	@ResponseBody
	public String validateChallenge12(@RequestBody User user,HttpServletRequest request,HttpServletResponse response) {
		Arrays.asList(request.getCookies()).stream().forEach(e->{e.setMaxAge(0);response.addCookie(e);});
		String userId=dao.getUserId(user.getUsername(),user.getPassword());
		if(!userId.isEmpty()) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),12);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.UPDAT_SCORE)
	@ResponseBody
	public String updatescore(@RequestBody String challenge,HttpServletRequest request) {
			dao.updateScore(HackMeHelper.getCookieValue(request, CommonConstants.USER_ID),Integer.parseInt(challenge));
			return CommonConstants.SUCCESS;
	}
}
