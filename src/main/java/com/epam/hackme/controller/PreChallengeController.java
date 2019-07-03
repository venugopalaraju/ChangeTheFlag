package com.epam.hackme.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;
import com.epam.hackme.validator.HackMeValidator;
@Controller
public class PreChallengeController {

	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(CommonConstants.TRIVIA)
	public String trivia(HttpServletRequest request,HttpServletResponse response) {
		return CommonConstants.TRIVIA_VIEW;
	}
	
	@RequestMapping(CommonConstants.TRIVIA_SUBMIT)
	public String triviasubmit(@ModelAttribute("trivia") Trivia trivia,BindingResult result,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserScore userscore=dao.getMyScore((String) session.getAttribute(CommonConstants.USER_ID));
		if(userscore.getScore()>0) {
			return "error";
		}else {
		HackMeValidator.validTriviaChallenges(trivia, result);
		if(result.hasErrors()) {
			return CommonConstants.TRIVIA_VIEW;
		}
		dao.updateScoreInFirstChallenge(HackMeHelper.getUserId(request),5);
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	}
	
	@RequestMapping(CommonConstants.TRIVIA_SKIP)
	public String triviasubmit(@ModelAttribute("trivia") Trivia trivia,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserScore userscore=dao.getMyScore((String) session.getAttribute(CommonConstants.USER_ID));
		if(userscore.getScore()>0) {
			return "error";
		}else {
		int score=HackMeValidator.validTriviaChallenges(trivia);
		dao.updateScoreInFirstChallenge(HackMeHelper.getUserId(request),score);
		return CommonConstants.CHALLENGE_ZERO_VIEW;
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
			return new ModelAndView(CommonConstants.CHALLENGE_ALL_VIEW, "challenge",0);
		}
		else {
			return new ModelAndView(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
	}
}
