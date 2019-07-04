package com.epam.hackme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;

@Controller
public class LoginController {
	
	@Autowired
	private HackMeDaoImpl dao;
	
	@RequestMapping({CommonConstants.USER_LOGIN,"/"})
	public String login(HttpServletRequest request,HttpServletResponse response) {
		HackMeHelper.clearCookies(request, response);
		return CommonConstants.USER_LOGIN_VIEW;
	}
	
	@RequestMapping(CommonConstants.VALIDATE_USER)
	public ModelAndView validateuser(User user,HttpServletRequest request,HttpServletResponse response) {
		if(dao.isValidUser(user)) {
			UserScore score=dao.getMyScore(user.getUserid());
			HttpSession session=request.getSession();
			session.setAttribute(CommonConstants.USER_ID, user.getUserid());
			if(score.getScore()>0) {
				session.setAttribute("challenge",score.getChallenge());
				return new ModelAndView("forward:"+CommonConstants.HACK_ALL);
			}else {
				dao.updateScoreTimestamp(user.getUserid());
				return new ModelAndView(CommonConstants.TRIVIA_ONE_VIEW);
			}
		}
		return new ModelAndView(CommonConstants.USER_LOGIN_VIEW, "error","Please enter valid Credentials");
	}
	
	
}
