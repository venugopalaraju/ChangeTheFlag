package com.epam.hackme.dto;

import java.io.Serializable;

public class UserScore implements Serializable{
	private static final long serialVersionUID = -6227117186724657311L;
	private String userid;
	private String userName;
	private int score;
	private int challenge;
	public int getChallenge() {
		return challenge;
	}
	public void setChallenge(int challenge) {
		this.challenge = challenge;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
