package com.epam.hackme.repository;

import com.epam.hackme.dto.User;

public interface HackMeDao {
public String getUserId(String query,String password);
public String registerUser(User user);
public Boolean isValidUser(User user);
}
