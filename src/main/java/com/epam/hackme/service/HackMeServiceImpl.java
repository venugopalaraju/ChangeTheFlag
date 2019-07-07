package com.epam.hackme.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.common.CommonConstants;
import com.epam.hackme.common.HackMeHelper;
import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;
import com.epam.hackme.repository.HackMeDaoImpl;
import com.epam.hackme.validator.HackMeValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	@Override
	public boolean isTriviaChallengeNotComepleted(HttpServletRequest request, int challenge) {
		Trivia trivia=dao.getTrivia(HackMeHelper.getUserId(request));
				switch(challenge) {
				case 0:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengezero());
				case 1:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengeone());
				case 2:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengetwo());
				case 3:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengethree());
				case 4:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefour());
				case 5:
					return CommonConstants.FLAG_N.equalsIgnoreCase(trivia.getChallengefive());
				default :
				return false;
			}
	}
	
	@Override
	public ModelAndView trivia(HttpServletRequest request, int challenge, ModelAndView mav) {
		if(isTriviaChallengeNotComepleted(request,challenge)) {
			HackMeHelper.prepareSameViewName(challenge, mav);
		}else {
			mav.setViewName(CommonConstants.ERROR);
		}
		return mav;
	}

	@Override
	public ModelAndView validateTriviaChallenge(HttpServletRequest request, ModelAndView mav, int challenge) {
		if(isTriviaChallengeNotComepleted(request,challenge)) {
			if(HackMeValidator.isCorrectAnswer(request.getParameter(PasswordConstants.ANSWER), challenge)) {
				String userid=HackMeHelper.getUserId(request);
				updateTriviaScore(userid, challenge);
				if(isTriviaChallengeNotComepleted(request,0)) {
					HackMeHelper.prepareNextViewName(challenge, mav);
				}else {
					mav.setViewName(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
				}
			}else {
				mav.addObject(CommonConstants.ERROR, PasswordConstants.WRONG);
				HackMeHelper.prepareSameViewName(challenge, mav);
			}
		}else {
			mav.setViewName(CommonConstants.ERROR);
		}
		return mav;
	}
	
	
	@Override
	public ModelAndView validateTriviaSkip(HttpServletRequest request, int challenge,ModelAndView mav) {
		if(isTriviaChallengeNotComepleted(request, 0)) {
			HackMeHelper.prepareNextViewName(challenge, mav);
		}else {
			mav.setViewName(CommonConstants.FORWARD+CommonConstants.HACK_ALL);
		}
		return mav;
	}

	
	@Override
	public ModelAndView validateChallengeZero(HttpServletRequest request, ModelAndView mav) throws JsonProcessingException {
		if(HackMeValidator.validateChallengeZero(request)) {
			String userid=HackMeHelper.getUserId(request);
			dao.updateTriviaChallenge0(userid);
			Trivia trivia=dao.getTrivia(userid);
			mav.addObject(CommonConstants.TRIVIA_FLAG, new ObjectMapper().writeValueAsString(trivia));
			mav.addObject(CommonConstants.CHALLENGE_FLAG,0);
			mav.setViewName(CommonConstants.CHALLENGE_ALL_VIEW);
		}
		else {
			mav.setViewName(CommonConstants.CHALLENGE_ZERO_VIEW);
		}
		return mav;
	}

	@Transactional(noRollbackFor=Exception.class)
	public void updateTriviaScore(String userid,int challenge) {
		switch(challenge) {
		case 0:
			dao.updateTriviaChallenge0(userid);
			break;
		case 1:
			dao.updateTriviaChallenge1(userid);
			break;
		case 2:
			dao.updateTriviaChallenge2(userid);
			break;
		case 3:
			dao.updateTriviaChallenge3(userid);
			break;
		case 4:
			dao.updateTriviaChallenge4(userid);
			break;
		case 5:
			dao.updateTriviaChallenge5(userid);
			break;
			}
		dao.updateTriviaScore(userid);
	}

	@Override
	public ModelAndView hackall(HttpServletRequest request, ModelAndView mav) throws JsonProcessingException {
		HttpSession session=request.getSession();
		String userid=HackMeHelper.getUserId(request);
		UserScore score=dao.getMyScore(userid);
		session.setAttribute(CommonConstants.CHALLENGE_FLAG,score.getChallenge());
		Trivia t=dao.getTrivia(HackMeHelper.getUserId(request));
		mav.addObject(CommonConstants.TRIVIA_FLAG, new ObjectMapper().writeValueAsString(t));
		mav.setViewName(CommonConstants.CHALLENGE_ALL_VIEW);
		return mav;
	}

	@Override
	public String validateChallenge(boolean isValid, HttpServletRequest request, int challenge) {
		if(isValid) {
		dao.updateScore(HackMeHelper.getUserId(request),challenge);
		return CommonConstants.SUCCESS;
	}
		return CommonConstants.NOT_SUCCESS;
	}
	
	
}
