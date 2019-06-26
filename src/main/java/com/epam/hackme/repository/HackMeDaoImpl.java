package com.epam.hackme.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.hackme.common.QueryConstants;
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


	@Override
	public String registerUser(User user) {
		int count= jdbcTemplate.update(QueryConstants.REGISTER_USER, user.getUserid(),user.getUsername(),user.getEmail(),user.getPassword());
		if(count>0) {
			jdbcTemplate.update(QueryConstants.ADD_SCORE,user.getUserid(),user.getUsername());
		}
		return count>0?user.getUserid():"Not Registered";
	}


	@Override
	public Boolean isValidUser(User user) {
		int count=jdbcTemplate.queryForObject(QueryConstants.IS_VALID_USER,Integer.class,user.getUserid(),user.getPassword());
		return count>0;
	}


	@Override
	public void updateScore(String userid, int challenge) {
		int count=jdbcTemplate.update(QueryConstants.UPDATE_SCORE,challenge,userid,userid,userid);
		System.out.println(challenge);
			}


	@Override
	public int updateScoreInFirstChallenge(String userId) {
		return jdbcTemplate.update(QueryConstants.UPDATE_SCORE_IN_FIRST_CHALLENGE, userId);
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
	
	
}
