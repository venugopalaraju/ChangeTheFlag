package com.epam.hackme.repository;

import java.util.List;

import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;

public interface HackMeDao {
public String getUserId(String query,String password);
public String registerUser(User user);
public Boolean isValidUser(User user);
public void updateScore(String userid,int challenge);
public int updateScoreInFirstChallenge(String userId,int score);
public List<UserScore> getSores();
public UserScore getMyScore(String userid);
public int updateScoreTimestamp(String userId);
}
