package com.epam.hackme.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.epam.hackme.dto.User;

public interface HackMeService {
public void registerUser(User user);
public ModelAndView validateUser(User user,HttpServletRequest request);
}
