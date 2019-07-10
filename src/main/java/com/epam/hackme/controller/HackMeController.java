package com.epam.hackme.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CacheService;
import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.service.HackMeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class HackMeController {

	@Autowired
	private HackMeService service;

	@RequestMapping({CommonConstants.CLICK_HERE})
	public String clickhere(HttpServletRequest request, ModelAndView mav) throws JsonProcessingException {
		try {
			if(HackMeHelper.getUserId(request).isEmpty()) {
				return CommonConstants.USER_LOGIN_VIEW;
			}
		}catch(Exception e) {
			return CommonConstants.USER_LOGIN_VIEW;
		}
		
		return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
	}
	@RequestMapping({CommonConstants.HACK_ALL,CommonConstants.USER_LOGIN_DEFAULT})
	public ModelAndView hackall(HttpServletRequest request, ModelAndView mav) throws JsonProcessingException {
		return service.hackall(request, mav);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ONE)
	@ResponseBody
	public String validateChallenge1(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.SOURCE_CODE_PASSWORD.equals(password), request, 1);
	}

	@RequestMapping(CommonConstants.CHALLENGE_TWO)
	public String challenge2(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie(PasswordConstants.PLAIN_COOKIE, PasswordConstants.PLAIN_COOKIE_VALUE));
		return CommonConstants.SUCCESS;
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TWO)
	@ResponseBody
	public String validatechallenge2(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.PLAIN_COOKIE_VALUE.equals(password), request, 2);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_THREE)
	@ResponseBody
	public String validateChallenge3(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.ENCRYPTED_SOURCE_CODE_PASSWORD_VALUE.equals(password),request, 3);
	}

	@RequestMapping(CommonConstants.CHALLENGE_FOUR)
	@ResponseBody
	public String challenge4(HttpServletRequest request, HttpServletResponse response) {
		return service.challenge4(request, response);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FOUR)
	@ResponseBody
	public String validateChallenge4(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(CacheService.getPassword(PasswordConstants.ENCRYPTED_COOKIE_PASSWORD_KEY, HackMeHelper.getUserId(request)).equals(password), request, 4);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_FIVE)
	@ResponseBody
	public String validateChallenge5(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.CHALLENG_5_PASSWORD.equals(password), request, 5);

	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_SIX)
	@ResponseBody
	public String validateChallenge6(HttpServletRequest request, HttpServletResponse response) {
		return service.validateChallenge6(request, response);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_SEVEN)
	@ResponseBody
	public String validatechallenge7(@RequestBody String value, HttpServletRequest request) {
		return service.validateChallenge(!value.isEmpty() && value.length() > 20, request, 7);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_EIGHT)
	@ResponseBody
	public String validateChallenge8(@RequestBody String password, HttpServletRequest request)throws IOException, InterruptedException {
		return service.validateChallenge(PasswordConstants.CHALLENG_8_PASSWORD.equals(password), request, 8);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_NINE)
	@ResponseBody
	public String validateChallenge9(@RequestBody String command) {
		return service.validateChallenge9(command);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_NINE_PWD)
	@ResponseBody
	public String validatechallenge9pwd(@RequestBody String password, HttpServletRequest request)throws IOException, InterruptedException {
		return service.validateChallenge(PasswordConstants.CHALLENG_9_PASSWORD.equals(password), request, 9);
	}

	@RequestMapping(CommonConstants.CHALLENGE_TEN)
	@ResponseBody
	public String challange10username(String getvalue) {
		return service.challange10username(getvalue);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TEN)
	@ResponseBody
	public String validateChallenge10(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.CHALLANGE_10_PASSWORD.equals(password), request, 10);
	}

	@RequestMapping(CommonConstants.CHALLENGE_ELEVEN)
	public String challange11login() {
		return CommonConstants.CHALLENGE_ELEVEN_VIEW;
	}

	@RequestMapping(CommonConstants.CHALLENGE_ELEVEN_ADMIN)
	@ResponseBody
	public String challange11admin() {
		return PasswordConstants.CHALLENGE_ELEVEN_PASSWORD;
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ELEVEN)
	@ResponseBody
	public String validateChallenge11(@RequestBody String password, HttpServletRequest request) {
		return service.validateChallenge(PasswordConstants.CHALLENGE_ELEVEN_PASSWORD.equals(password), request, 11);
	}

	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_TWELVE)
	@ResponseBody
	public String validateChallenge12(@RequestBody User user, HttpServletRequest request) {
		return service.validateChallenge12(user, request);
	}

	@RequestMapping(CommonConstants.GET_SCORES)
	@ResponseBody
	public List<UserScore> getscores() {
		return service.getscores();
	}

	@RequestMapping(CommonConstants.GET_MY_SCORE)
	@ResponseBody
	public String getMyScore(HttpServletRequest request) {
		return service.getMyScore(request);
	}
	
	@RequestMapping(CommonConstants.GET_MY_SCORE_CARD)
	@ResponseBody
	public String getMyScoreCard(HttpServletRequest request) {
		return service.getMyScoreCard(request);
	}
	
	@RequestMapping(path = CommonConstants.PASSWORD_TXT, method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> password(HttpServletRequest request) throws Exception {
	    if(HackMeHelper.getUserId(request).isEmpty()) {
	    	 throw new Exception();
	    }
	    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(new File(ClassLoader.getSystemClassLoader().getResource(CommonConstants.PASSWORD_TXT_FILE_PATH).getFile()).toPath()));
	    return ResponseEntity.ok()
	    		.header(CommonConstants.CACHE_CONTROL,CommonConstants.NO_CACHE)
	            .contentType(MediaType.parseMediaType(CommonConstants.TEXT_PLAIN))
	            .body(resource);
	}
}
