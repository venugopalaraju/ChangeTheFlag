package com.epam.hackme.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.hackme.common.QueryConstants;

@Repository
public class HackMeDaoImpl implements HackMeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String getUserId(String username,String password) {
		return jdbcTemplate.queryForObject(QueryConstants.GET_USERNAME+username+" AND PASSWORD="+password, String.class);
	}

}
