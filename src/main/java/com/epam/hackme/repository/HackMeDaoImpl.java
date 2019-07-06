package com.epam.hackme.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.hackme.common.QueryConstants;
import com.epam.hackme.dto.Trivia;
import com.epam.hackme.dto.User;
import com.epam.hackme.dto.UserScore;

@Repository
public class HackMeDaoImpl implements HackMeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String getUserId(String username,String password) {
		return jdbcTemplate.queryForObject(QueryConstants.GET_USER_ID+username+" AND PASSWORD="+password, String.class);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void registerUser(User user) {
			jdbcTemplate.update(QueryConstants.REGISTER_USER, user.getUserid(),user.getUsername(),user.getEmail(),user.getPassword());
			jdbcTemplate.update(QueryConstants.ADD_SCORE,user.getUserid(),user.getUsername());
			jdbcTemplate.update(QueryConstants.ADD_TRIVIA,user.getUserid());
	}


	@Override
	public Boolean isValidUser(User user) {
		int count=jdbcTemplate.queryForObject(QueryConstants.IS_VALID_USER,Integer.class,user.getUserid(),user.getPassword());
		return count>0;
	}


	@Override
	public void updateScore(String userid, int challenge) {
		UserScore score=getMyScore(userid);
		if(challenge>score.getChallenge()) {
		jdbcTemplate.update(QueryConstants.UPDATE_SCORE,challenge,userid,userid,userid);
		}
			}


	@Override
	public void updateTriviaScore(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_SCORE_TRIVIAL,userid,userid);
	}


	@Override
	public void updateScoreInFirstChallenge(String userId,int score) {
		jdbcTemplate.update(QueryConstants.UPDATE_SCORE_TRIVIAL, score,userId);
	}


	@Override
	public void updateScoreTimestamp(String userId) {
		jdbcTemplate.update(QueryConstants.UPDATE_SCORE_IN_FIRST_CHALLENGE,userId);
	}


	@Override
	public List<UserScore> getSores() {
		return jdbcTemplate.query(QueryConstants.GET_SCORE,(rs,rowNum)->{
					UserScore score=new UserScore();
					score.setUserid(rs.getString("USER_ID"));
					score.setUserName(rs.getString("USER_NAME"));
					score.setScore(rs.getInt("SCORE"));
				return score;
			});
	}


	@Override
	public UserScore getMyScore(String userid) {
		return jdbcTemplate.query(QueryConstants.GET_My_SCORE, (rs,rowNum)->{
			UserScore score=new UserScore();
			score.setUserid(rs.getString("USER_ID"));
			score.setUserName(rs.getString("USER_NAME"));
			score.setScore(rs.getInt("SCORE"));
			score.setChallenge(rs.getInt("CHALLENGE"));
		return score;
		}, userid).get(0);
	}


	@Override
	public Trivia getTrivia(String userid) {
		return jdbcTemplate.query(QueryConstants.GET_TRIVIA_CHALLENGES, (rs,rowNum)->{
			Trivia t=new Trivia();
			t.setChallengezero(rs.getString("CHALLENGE0"));
			t.setChallengeone(rs.getString("CHALLENGE1"));
			t.setChallengetwo(rs.getString("CHALLENGE2"));
			t.setChallengethree(rs.getString("CHALLENGE3"));
			t.setChallengefour(rs.getString("CHALLENGE4"));
			t.setChallengefive(rs.getString("CHALLENGE5"));
		return t;
		}, userid).get(0);
	}


	@Override
	public void updateTriviaChallenge0(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_CHALLENGE_ZERO, userid);
	}


	@Override
	public void updateTriviaChallenge1(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_TRIVIA_ONE, userid);
	}


	@Override
	public void updateTriviaChallenge2(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_TRIVIA_TwO, userid);
	}


	@Override
	public void updateTriviaChallenge3(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_TRIVIA_THREE, userid);
	}


	@Override
	public void updateTriviaChallenge4(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_TRIVIA_FOUR, userid);
	}


	@Override
	public void updateTriviaChallenge5(String userid) {
		jdbcTemplate.update(QueryConstants.UPDATE_TRIVIA_FIVE, userid);
	}
	
	
}
