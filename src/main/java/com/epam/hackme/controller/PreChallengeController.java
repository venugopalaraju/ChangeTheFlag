package com.epam.hackme.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.repository.HackMeDaoImpl;
import com.epam.hackme.validator.HackMeValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class PreChallengeController {

	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping(CommonConstants.TRIVIA_ONE)
	public String triviachallengeone(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengeone())) {
			return CommonConstants.TRIVIA_ONE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO)
	public String triviachallengetwo(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengetwo())) {
			return CommonConstants.TRIVIA_TWO_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE)
	public String triviachallengethree(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengethree())) {
			return CommonConstants.TRIVIA_THREE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR)
	public String triviachallengefour(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefour())) {
			return CommonConstants.TRIVIA_FOUR_VIEW;
		}
		return CommonConstants.ERROR;
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE)
	public String triviachallengefive(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefive())) {
			return CommonConstants.TRIVIA_FIVE_VIEW;
		}
		return CommonConstants.ERROR;
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_VALIDATE)
	public ModelAndView validatetriviachallengeone(HttpServletRequest request,ModelAndView mav) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengeone())) {
			String answer=request.getParameter(PasswordConstants.ANSWER);
			if(PasswordConstants.TRIVIA_ANSWER_ONE.equalsIgnoreCase(answer)||PasswordConstants.TRIVIA_ANSWER_ONE_1.equalsIgnoreCase(answer)) {
				String userid=HackMeHelper.getUserId(request);
				dao.updateTriviaChallenge1(userid);
				dao.updateTriviaScore(userid);
				if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
					return new ModelAndView(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
				}
				mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
				return mav;
			}
			mav.setViewName(CommonConstants.TRIVIA_ONE_VIEW);
			mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
			return mav;
		}else {
			return new ModelAndView(CommonConstants.ERROR);
		}	
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_VALIDATE)
	public ModelAndView validatetriviachallengetwo(HttpServletRequest request,ModelAndView mav) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengetwo())) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_TWO.equalsIgnoreCase(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge2(userid);
			dao.updateTriviaScore(userid);
			if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
				return new ModelAndView(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
			}
			mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_TWO_VIEW);
		mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
		return mav;
		}else {
			return new ModelAndView(CommonConstants.ERROR);
		}
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_VALIDATE)
	public ModelAndView validatetriviachallengethree(HttpServletRequest request,ModelAndView mav) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengethree())) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_THREE.equalsIgnoreCase(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge3(userid);
			dao.updateTriviaScore(userid);
			if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
				return new ModelAndView(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
			}
			mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_THREE_VIEW);
		mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
		return mav;
		}else {
			return new ModelAndView(CommonConstants.ERROR);
		}
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_VALIDATE)
	public ModelAndView validatetriviachallengefour(HttpServletRequest request,ModelAndView mav) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefour())) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_FOUR.equalsIgnoreCase(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge4(userid);
			dao.updateTriviaScore(userid);
			if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
				return new ModelAndView(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
			}
			mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_FOUR_VIEW);
		mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
		return mav;
		}else {
			return new ModelAndView(CommonConstants.ERROR);
		}
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_VALIDATE)
	public ModelAndView validatetriviachallengefive(HttpServletRequest request,ModelAndView mav) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefive())) {
		String answer=request.getParameter(PasswordConstants.ANSWER);
		if(PasswordConstants.TRIVIA_ANSWER_FIVE.equalsIgnoreCase(answer)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge5(userid);
			dao.updateTriviaScore(userid);
			if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
				return new ModelAndView(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
			}
			mav.setViewName(CommonConstants.CHALLENGE_ZERO_VIEW);
			return mav;
		}
		mav.setViewName(CommonConstants.TRIVIA_FIVE_VIEW);
		mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
		return mav;
		}else {
			return new ModelAndView(CommonConstants.ERROR);
		}
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengeone(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
			return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
		}
		return CommonConstants.TRIVIA_TWO_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_SKIP_VALIDATE)
	public String skipvalidatetriviachallengetwo(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
			return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
		}
		return CommonConstants.TRIVIA_THREE_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengethree(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
			return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
		}
		return CommonConstants.TRIVIA_FOUR_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_SKIP_VALIDATE)
	public String skipvalidatetriviachallengefour(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
			return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
		}
		return CommonConstants.TRIVIA_FIVE_VIEW;
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_SKIP_VALIDATE)
	public String skipvalidatetriviachallengefive(HttpServletRequest request) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
		if(CommonConstants.FLAG_Y.equalsIgnoreCase(trivia.getChallengezero())) {
			return CommonConstants.FORWARD+CommonConstants.HACK_ALL;
		}
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	
	@RequestMapping(CommonConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ZERO)
	public ModelAndView hackall(HttpServletRequest request,ModelAndView mav) throws JsonProcessingException {
		if(HackMeValidator.validateChallengeZero(request)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge0(userid);
			Trivia trivia=dao.getTrivia(userid);
			mav.addObject(CommonConstants.TRIVIA_FLAG, new ObjectMapper().writeValueAsString(trivia));
			mav.addObject(CommonConstants.CHALLENGE_FLAG,0);
			mav.setViewName(CommonConstants.CHALLENGE_ALL_VIEW);
			return mav;
		}
		else {
			return new ModelAndView(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
	}
}
