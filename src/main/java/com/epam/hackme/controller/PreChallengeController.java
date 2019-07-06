package com.epam.hackme.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.service.HackMeService;
import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
public class PreChallengeController {
	
	@Autowired
	private HackMeService service;
	
	@RequestMapping(CommonConstants.TRIVIA_ONE)
	public ModelAndView triviachallengeone(HttpServletRequest request, ModelAndView mav) {
		return service.trivia(request, 1, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO)
	public ModelAndView triviachallengetwo(HttpServletRequest request, ModelAndView mav) {
		return service.trivia(request, 2, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE)
	public ModelAndView triviachallengethree(HttpServletRequest request, ModelAndView mav) {
		return service.trivia(request, 3, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR)
	public ModelAndView triviachallengefour(HttpServletRequest request, ModelAndView mav) {
		return service.trivia(request, 4, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE)
	public ModelAndView triviachallengefive(HttpServletRequest request, ModelAndView mav) {
		return service.trivia(request,5, mav);
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_VALIDATE)
	public ModelAndView validatetriviachallengeone(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaChallenge(request, mav, 1);
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_VALIDATE)
	public ModelAndView validatetriviachallengetwo(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaChallenge(request, mav, 2);
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_VALIDATE)
	public ModelAndView validatetriviachallengethree(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaChallenge(request, mav, 3);
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_VALIDATE)
	public ModelAndView validatetriviachallengefour(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaChallenge(request, mav, 4);
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_VALIDATE)
	public ModelAndView validatetriviachallengefive(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaChallenge(request, mav, 5);
	}
	
	@RequestMapping(CommonConstants.TRIVIA_ONE_SKIP_VALIDATE)
	public ModelAndView skipvalidatetriviachallengeone(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaSkip(request, 1, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_TWO_SKIP_VALIDATE)
	public ModelAndView skipvalidatetriviachallengetwo(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaSkip(request, 2, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_THREE_SKIP_VALIDATE)
	public ModelAndView skipvalidatetriviachallengethree(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaSkip(request, 3, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_FOUR_SKIP_VALIDATE)
	public ModelAndView skipvalidatetriviachallengefour(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaSkip(request, 4, mav);
	}
	@RequestMapping(CommonConstants.TRIVIA_FIVE_SKIP_VALIDATE)
	public ModelAndView skipvalidatetriviachallengefive(HttpServletRequest request,ModelAndView mav) {
		return service.validateTriviaSkip(request, 5, mav);
	}
	
	@RequestMapping(CommonConstants.CHALLENGE_ZERO)
	public String challangelogin(HttpServletRequest request,HttpServletResponse response) {
		return CommonConstants.CHALLENGE_ZERO_VIEW;
	}
	
	@RequestMapping(CommonConstants.VALIDATE_CHALLENGE_ZERO)
	public ModelAndView hackall(HttpServletRequest request,ModelAndView mav) throws JsonProcessingException {
		return service.validateChallengeZero(request, mav);
	}
}
