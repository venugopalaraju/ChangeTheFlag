package com.epam.hackme.dto;

import java.io.Serializable;
public class Trivia implements Serializable{
private static final long serialVersionUID = -142825398680427754L;
private String challengezero;
private String challengeone;
private String challengetwo;
private String challengethree;
private String challengefour;
private String challengefive;
public String getChallengeone() {
	return challengeone;
}
public void setChallengeone(String challengeone) {
	this.challengeone = challengeone;
}
public String getChallengetwo() {
	return challengetwo;
}
public void setChallengetwo(String challengetwo) {
	this.challengetwo = challengetwo;
}
public String getChallengethree() {
	return challengethree;
}
public void setChallengethree(String challengethree) {
	this.challengethree = challengethree;
}
public String getChallengefour() {
	return challengefour;
}
public void setChallengefour(String challengefour) {
	this.challengefour = challengefour;
}
public String getChallengefive() {
	return challengefive;
}
public void setChallengefive(String challengefive) {
	this.challengefive = challengefive;
}
public String getChallengezero() {
	return challengezero;
}
public void setChallengezero(String challengezero) {
	this.challengezero = challengezero;
}

}
