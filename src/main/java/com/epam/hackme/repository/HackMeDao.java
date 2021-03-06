package com.epam.hackme.repository;

import java.util.List;

import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;

public interface HackMeDao {
public String getUserId(String query,String password);
public void registerUser(User user);
public Boolean isValidUser(User user);
public void updateScore(String userid,int challenge);
public void updateTriviaScore(String userid);
public void updateScoreInFirstChallenge(String userId,int score);
public List<UserScore> getSores();
public UserScore getMyScore(String userid);
public void updateScoreTimestamp(String userId);
public Trivia getTrivia(String userid);
public void updateTriviaChallenge0(String userid);
public void updateTriviaChallenge1(String userid);
public void updateTriviaChallenge2(String userid);
public void updateTriviaChallenge3(String userid);
public void updateTriviaChallenge4(String userid);
public void updateTriviaChallenge5(String userid);
}
