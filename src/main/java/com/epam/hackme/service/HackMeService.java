package com.epam.hackme.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface HackMeService {
public void registerUser(User user);
public ModelAndView validateUser(User user,HttpServletRequest request);
public boolean isTriviaChallengeNotComepleted(HttpServletRequest request,int challenge);
public ModelAndView trivia(HttpServletRequest request,int challenge,ModelAndView mav);
public ModelAndView validateTriviaChallenge(HttpServletRequest request,ModelAndView mav,int challenge);
public ModelAndView validateTriviaSkip(HttpServletRequest request,int challenge,ModelAndView mav);
public ModelAndView validateChallengeZero(HttpServletRequest request,ModelAndView mav) throws JsonProcessingException;
}
