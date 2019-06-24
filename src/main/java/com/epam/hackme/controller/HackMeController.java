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
import com.epam.hackme.common.HackMeConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.dto.User;
import com.epam.hackme.repository.HackMeDaoImpl;

@Controller
public class HackMeController {
	
	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(HackMeConstants.USER_LOGIN)
	public String login() {
		return HackMeConstants.USER_LOGIN_VIEW;
	}
	@RequestMapping(HackMeConstants.VALIDATE_USER)
	public ModelAndView validateuser(User user) {
		if(dao.isValidUser(user)) {
			return new ModelAndView(HackMeConstants.CHALLENGE_ZERO_VIEW);
		}
		return new ModelAndView(HackMeConstants.USER_LOGIN_VIEW, "error","Please enter valid Credentials");
	}
	@RequestMapping(HackMeConstants.REGISTRATION)
	public ModelAndView registeration() {
		return new ModelAndView(HackMeConstants.REGISTRATION_VIEW, "user", new User());
	}
	@RequestMapping(HackMeConstants.REGISTRATION_USER)
	public ModelAndView registeruser(User user) {
		try {
		String registereduserid=dao.registerUser(user);
		if(registereduserid.equalsIgnoreCase(user.getUserid())) {
		return new ModelAndView(HackMeConstants.USER_LOGIN, "userid",registereduserid);
		}else {
			return new ModelAndView(HackMeConstants.REGISTRATION_VIEW, "error","Please enter valid details and click on register");
		}
		}catch(Exception e) {
			return new ModelAndView(HackMeConstants.REGISTRATION_VIEW, "error","Please enter valid details and click on register");
		}
		}
	@RequestMapping(HackMeConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
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
	@RequestMapping(HackMeConstants.CHALLENGE_TWO)
	public String challenge2(HttpServletResponse response) {
		response.addCookie(new Cookie(HackMeConstants.PLAIN_COOKIE, HackMeConstants.PLAIN_COOKIE_VALUE));
		return HackMeConstants.SUCCESS;
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
	
	@RequestMapping(HackMeConstants.CHALLENGE_FOUR)
	@ResponseBody
	public String challenge4(HttpServletResponse response) {
		String password=HackMeHelper.convertPlainToCipher(HackMeHelper.generateRandomString(10));
		response.addCookie(new Cookie(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, Base64Utils.encodeToString(password.getBytes())));
		CacheService.savePassword(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, password);
		return HackMeConstants.SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_FOUR)
	@ResponseBody
	public String validateChallenge4(@RequestBody String password) {
		if(CacheService.getPassword(HackMeConstants.ENCRYPTED_COOKIE_PASSWORD_KEY).equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_FIVE)
	@ResponseBody
	public String validateChallenge5(@RequestBody String password) {
		if(HackMeConstants.CHALLENG_5_PASSWORD.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_SIX)
	@ResponseBody
	public String validateChallenge6(HttpServletRequest request,HttpServletResponse response) {
		if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(HackMeConstants.ROLE_TYPE)&&e.getValue().equals(HackMeConstants.ADMIN_ROLE))) {
			return HackMeConstants.ADMIN_ROLE;
		}else if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(HackMeConstants.ROLE_TYPE)&&e.getValue().equals(HackMeConstants.USER_ROLE))) {
			return HackMeConstants.USER_ROLE;
		}
		response.addCookie(new Cookie(HackMeConstants.ROLE_TYPE, HackMeConstants.USER_ROLE));
		return HackMeConstants.USER_ROLE;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_EIGHT)
	@ResponseBody
	public String validateChallenge8(@RequestBody String password) throws IOException, InterruptedException {
		if(HackMeConstants.CHALLENG_8_PASSWORD.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
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
	@RequestMapping(HackMeConstants.CHALLENGE_TEN)
	@ResponseBody
	public String challange10username(String getvalue)  {
		if(getvalue.equals(HackMeConstants.USERNAME)) {
			return HackMeConstants.ADMIN;
		}else if(getvalue.equals(HackMeConstants.PASSWORD)){
			return HackMeConstants.CHALLANGE_10_PASSWORD;
		}
		return HackMeConstants.INVALID_URL;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_TEN)
	@ResponseBody
	public String validateChallenge10(@RequestBody String password) {
		if(HackMeConstants.CHALLANGE_10_PASSWORD.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
	}
	@RequestMapping(HackMeConstants.CHALLENGE_ELEVEN)
	public String challangelogin() {
		return HackMeConstants.CHALLENGE_ELEVEN_VIEW;
	}
	@RequestMapping(HackMeConstants.CHALLENGE_ELEVEN_ADMIN)
	@ResponseBody
	public String challange11admin() {
		return HackMeConstants.CHALLENGE_ELEVEN_PASSWORD;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_ELEVEN)
	@ResponseBody
	public String validateChallenge11(@RequestBody String password) {
		if(HackMeConstants.CHALLENGE_ELEVEN_PASSWORD.equals(password)) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
	}
	@RequestMapping(HackMeConstants.VALIDATE_CHALLENGE_TWELVE)
	@ResponseBody
	public String validateChallenge12(@RequestBody User user,HttpServletRequest request,HttpServletResponse response) {
		Arrays.asList(request.getCookies()).stream().forEach(e->{e.setMaxAge(0);response.addCookie(e);});
		String userId=dao.getUserId(user.getUsername(),user.getPassword());
		if(!userId.isEmpty()) {
			return HackMeConstants.SUCCESS;
		}
		return HackMeConstants.NOT_SUCCESS;
	}
}
