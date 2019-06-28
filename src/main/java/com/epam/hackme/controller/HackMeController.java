package com.epam.hackme.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;

@Controller
public class HackMeController {
	
	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping({CommonConstants.USER_LOGIN,"/"})
	public String login(HttpServletRequest request,HttpServletResponse response) {
		HackMeHelper.clearCookies(request, response);
		return CommonConstants.USER_LOGIN_VIEW;
	}
	@RequestMapping(CommonConstants.HACK_ALL)
	public String hackall(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		String userid=HackMeHelper.getUserId(request);
		UserScore score=dao.getMyScore(userid);
		session.setAttribute("challenge",score.getChallenge());
		return CommonConstants.CHALLENGE_ALL_VIEW;
	}
	@RequestMapping(CommonConstants.VALIDATE_USER)
	public ModelAndView validateuser(User user,HttpServletRequest request,HttpServletResponse response) {
		if(dao.isValidUser(user)) {
			//response.addCookie(new Cookie(CommonConstants.USER_ID, user.getUserid()));
			UserScore score=dao.getMyScore(user.getUserid());
			HttpSession session=request.getSession();
			session.setAttribute(CommonConstants.USER_ID, user.getUserid());
			if(score.getScore()>0) {
				session.setAttribute("challenge",score.getChallenge());
				return new ModelAndView("forward:"+CommonConstants.HACK_ALL);
			}
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
	public ModelAndView hackall(HttpServletRequest request) {
		String username=request.getParameter(CommonConstants.USERNAME);
		String password=request.getParameter(CommonConstants.PASSWORD);
		if(username.equalsIgnoreCase(CommonConstants.ADMIN)&&password.equalsIgnoreCase(CommonConstants.ADMIN)) {
			dao.updateScoreInFirstChallenge(HackMeHelper.getUserId(request));
			return new ModelAndView(CommonConstants.CHALLENGE_ALL_VIEW, "challenge",0);
		}
		else {
			return new ModelAndView(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ONE)
	@ResponseBody
	public String validateChallenge1(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.SOURCE_CODE_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),1);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.CHALLENGE_TWO)
	public String challenge2(HttpServletRequest request,HttpServletResponse response) {
		response.addCookie(new Cookie(CommonConstants.PLAIN_COOKIE, CommonConstants.PLAIN_COOKIE_VALUE));
		return CommonConstants.SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TWO)
	@ResponseBody
	public String validatechallenge2(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.PLAIN_COOKIE_VALUE.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),2);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_THREE)
	@ResponseBody
	public String validateChallenge3(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),3);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	
	@RequestMapping(CommonConstants.CHALLENGE_FOUR)
	@ResponseBody
	public String challenge4(HttpServletRequest request,HttpServletResponse response) {
		String password=HackMeHelper.convertPlainToCipher(HackMeHelper.generateRandomString(10));
		String userId=HackMeHelper.getUserId(request);
		response.addCookie(new Cookie(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, Base64Utils.encodeToString(password.getBytes())));
		CacheService.savePassword(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, password,userId);
		return CommonConstants.SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FOUR)
	@ResponseBody
	public String validateChallenge4(@RequestBody String password,HttpServletRequest request) {
		if(CacheService.getPassword(CommonConstants.ENCRYPTED_COOKIE_PASSWORD_KEY,HackMeHelper.getUserId(request)).equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),4);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FIVE)
	@ResponseBody
	public String validateChallenge5(@RequestBody String password,HttpServletRequest request) {
		if(CommonConstants.CHALLENG_5_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),5);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_SIX)
	@ResponseBody
	public String validateChallenge6(HttpServletRequest request,HttpServletResponse response) {
		if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(CommonConstants.ROLE_TYPE)&&e.getValue().equals(CommonConstants.ADMIN_ROLE))) {
			dao.updateScore(HackMeHelper.getUserId(request),6);
			return CommonConstants.SUCCESS;
		}else if(Arrays.asList(request.getCookies()).stream().anyMatch(e->e.getName().equals(CommonConstants.ROLE_TYPE)&&e.getValue().equals(CommonConstants.USER_ROLE))) {
			return CommonConstants.NOT_SUCCESS;
		}
		response.addCookie(new Cookie(CommonConstants.ROLE_TYPE, CommonConstants.USER_ROLE));
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_SEVEN)
	@ResponseBody
	public String validatechallenge7(@RequestBody String value,HttpServletRequest request) {
		if(!value.isEmpty()&&value.length()>20) {
			dao.updateScore(HackMeHelper.getUserId(request),7);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
		
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_EIGHT)
	@ResponseBody
	public String validateChallenge8(@RequestBody String password,HttpServletRequest request) throws IOException, InterruptedException {
		if(CommonConstants.CHALLENG_8_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),8);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_NINE)
	@ResponseBody
	public String validateChallenge9(@RequestBody String command) {
		try {
		String output="";
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe", "/c", "ping "+command);
		Process proc = processBuilder.start();
		int result = proc.waitFor();
		InputStream in = (result == 0) ? proc.getInputStream() : proc.getErrorStream();
		int c;
		while ((c = in.read()) != -1) {
			output=output+(char)c;
		}
		return output;
		}catch(IOException|InterruptedException e) {
			return "Please enter valid command";
		}
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_NINE_PWD)
	@ResponseBody
	public String validatechallenge9pwd(@RequestBody String password,HttpServletRequest request) throws IOException, InterruptedException {
		if(CommonConstants.CHALLENG_9_PASSWORD.equals(password)) {
			dao.updateScore(HackMeHelper.getUserId(request),9);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
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
			dao.updateScore(HackMeHelper.getUserId(request),10);
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
			dao.updateScore(HackMeHelper.getUserId(request),11);
			return CommonConstants.SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TWELVE)
	@ResponseBody
	public String validateChallenge12(@RequestBody User user,HttpServletRequest request,HttpServletResponse response) {
		try {
		String userId=dao.getUserId(user.getUsername(),user.getPassword());
		if(!userId.isEmpty()) {
			dao.updateScore(HackMeHelper.getUserId(request),12);
			return CommonConstants.SUCCESS;
		}
		}catch(Exception e) {
			return CommonConstants.NOT_SUCCESS;
		}
		return CommonConstants.NOT_SUCCESS;
	}
	@RequestMapping(CommonConstants.GET_SCORES)
	@ResponseBody
	public String getscores(HttpServletRequest request) {
		List<UserScore> scores=dao.getSores();
		return HackMeHelper.getScoreBoard(scores,HackMeHelper.getUserId(request));
	}
	@RequestMapping(CommonConstants.GET_MY_SCORE)
	@ResponseBody
	public String getMyScore(HttpServletRequest request) {
		UserScore score=dao.getMyScore(HackMeHelper.getUserId(request));
		return HackMeHelper.getMyScore(score);
	}
}
