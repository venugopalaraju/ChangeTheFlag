package com.epam.hackme.configuaration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class HackMeDatasource {
	
	@Autowired
	private DataSource dataSource;
		
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
		
	}
}
