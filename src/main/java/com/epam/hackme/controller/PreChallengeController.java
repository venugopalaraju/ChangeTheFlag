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
import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;
import com.epam.hackme.validator.HackMeValidator;
@Controller
public class PreChallengeController {

	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(CommonConstants.TRIVIA_ONE)
	public String triviachallengeone(HttpServletRequest request) {
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		if(t.getChallengeone().equals("N")) {
			return CommonConstants.TRIVIA_ONE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO)
	public String triviachallengetwo(HttpServletRequest request) {
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		if(t.getChallengetwo().equals("N")) {
			return CommonConstants.TRIVIA_TWO_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE)
	public String triviachallengethree(HttpServletRequest request) {
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		if(t.getChallengethree().equals("N")) {
			return CommonConstants.TRIVIA_THREE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR)
	public String triviachallengefour(HttpServletRequest request) {
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		if(t.getChallengefour().equals("N")) {
			return CommonConstants.TRIVIA_FOUR_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE)
	public String triviachallengefive(HttpServletRequest request) {
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		if(t.getChallengefive().equals("N")) {
			return CommonConstants.TRIVIA_FIVE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_VALIDATE)
	public ModelAndView validatetriviachallengeone(HttpServletRequest request,ModelAndView mav) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_ONE.equals(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge1(userid);
			dao.updateTriviaScore(userid, 0);
			mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_ONE_VIEW);
		mav.addObject("error", PasswordConstants.WRONG);
		return mav;
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_VALIDATE)
	public ModelAndView validatetriviachallengetwo(HttpServletRequest request,ModelAndView mav) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_TWO.equals(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge2(userid);
			dao.updateTriviaScore(userid, 0);
			mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
		mav.addObject("error", PasswordConstants.WRONG);
		return mav;
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_VALIDATE)
	public ModelAndView validatetriviachallengethree(HttpServletRequest request,ModelAndView mav) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_THREE.equals(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge3(userid);
			dao.updateTriviaScore(userid, 0);
			mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
		mav.addObject("error", PasswordConstants.WRONG);
		return mav;
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_VALIDATE)
	public ModelAndView validatetriviachallengefour(HttpServletRequest request,ModelAndView mav) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_FOUR.equals(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge4(userid);
			dao.updateTriviaScore(userid, 0);
			mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
		mav.addObject("error", PasswordConstants.WRONG);
		return mav;
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_VALIDATE)
	public ModelAndView validatetriviachallengefive(HttpServletRequest request,ModelAndView mav) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_FIVE.equals(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge5(userid);
			dao.updateTriviaScore(userid, 0);
			mav.setViewName(CommonConstants.CHALLENGE_ZERO_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
		mav.addObject("error", PasswordConstants.WRONG);
		return mav;
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengeone() {
		return CommonConstants.TRIVIA_TWO_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_SKIP_VALIDATE)
	public String skipvalidatetriviachallengetwo() {
		return CommonConstants.TRIVIA_THREE_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengethree() {
		return CommonConstants.TRIVIA_FOUR_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_SKIP_VALIDATE)
	public String skipvalidatetriviachallengefour() {
		return CommonConstants.TRIVIA_FIVE_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengefive() {
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	
	/*@RequestMapping(CommonConstants.TRIVIA_SUBMIT)
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
	*/
	@RequestMapping(CommonConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ZERO)
	public ModelAndView hackall(HttpServletRequest request) {
		if(HackMeValidator.validateChallengeZero(request)) {
			return new ModelAndView(CommonConstants.CHALLENGE_ALL_VIEW, "challenge",0);
		}
		else {
			return new ModelAndView(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
	}
}
