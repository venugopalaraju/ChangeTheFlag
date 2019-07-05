package com.epam.hackme.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;
@Service
public class HackMeServiceImpl implements HackMeService{
	@Autowired
	private HackMeDaoImpl dao;

	@Override
	public void registerUser(User user) {
		dao.registerUser(user);
	}

	@Override
	public ModelAndView validateUser(User user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (dao.isValidUser(user)) {
			UserScore score = dao.getMyScore(user.getUserid());
			HttpSession session = request.getSession();
			session.setAttribute(CommonConstants.USER_ID, user.getUserid());
			if (score.getScore() > 0) {
				session.setAttribute(CommonConstants.CHALLENGE_FLAG, score.getChallenge());
				mav.setViewName(CommonConstants.FORWARD + CommonConstants.HACK_ALL);
			} else {
				dao.updateScoreTimestamp(user.getUserid());
				mav.setViewName(CommonConstants.TRIVIA_ONE_VIEW);
			}
		} else {
			mav.addObject(CommonConstants.ERROR, "Please enter valid Credentials");
			mav.setViewName(CommonConstants.USER_LOGIN_VIEW);
		}
		return mav;
	}

	
	
}
