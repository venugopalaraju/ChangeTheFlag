package com.epam.hackme.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.hackme.common.QueryConstants;
import com.epam.hackme.dto.User;

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
			jdbcTemplate.update(QueryConstants.ADD_SCORE,user.getUserid());
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
		int count=jdbcTemplate.update(QueryConstants.UPDATE_SCORE,challenge,userid,userid);
		System.out.println(challenge);
			}
}
