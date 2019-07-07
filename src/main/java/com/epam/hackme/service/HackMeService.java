package com.epam.hackme.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface HackMeService {
public void registerUser(User user);
public ModelAndView validateUser(User user,HttpServletRequest request);
public boolean isTriviaChallengeNotComepleted(HttpServletRequest request,int challenge);
public ModelAndView trivia(HttpServletRequest request,int challenge,ModelAndView mav);
public ModelAndView validateTriviaChallenge(HttpServletRequest request,ModelAndView mav,int challenge);
public ModelAndView validateTriviaSkip(HttpServletRequest request,int challenge,ModelAndView mav);
public ModelAndView validateChallengeZero(HttpServletRequest request,ModelAndView mav) throws JsonProcessingException;
public ModelAndView hackall(HttpServletRequest request,ModelAndView mav) throws JsonProcessingException;
public String validateChallenge(boolean isValid,HttpServletRequest request,int challenge);
public String challenge4(HttpServletRequest request,HttpServletResponse response);
public String validateChallenge6(HttpServletRequest request,HttpServletResponse response);
public String validateChallenge9(String command);
public String challange10username(String getvalue);
public String validateChallenge12(@RequestBody User user,HttpServletRequest request);
public List<UserScore> getscores();
public String getMyScore(HttpServletRequest request);
}
