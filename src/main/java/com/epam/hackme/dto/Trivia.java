package com.epam.hackme.dto;

import java.io.Serializable;
public class Trivia implements Serializable{
private static final long serialVersionUID = -142825398680427754L;

private String triviaAnswerOne;
private String triviaAnswerTwo;
private String triviaAnswerThree;
private String triviaAnswerFour;
private String triviaAnswerFive;
public String getTriviaAnswerOne() {
	return triviaAnswerOne;
}
public void setTriviaAnswerOne(String triviaAnswerOne) {
	this.triviaAnswerOne = triviaAnswerOne;
}
public String getTriviaAnswerTwo() {
	return triviaAnswerTwo;
}
public void setTriviaAnswerTwo(String triviaAnswerTwo) {
	this.triviaAnswerTwo = triviaAnswerTwo;
}
public String getTriviaAnswerThree() {
	return triviaAnswerThree;
}
public void setTriviaAnswerThree(String triviaAnswerThree) {
	this.triviaAnswerThree = triviaAnswerThree;
}
public String getTriviaAnswerFour() {
	return triviaAnswerFour;
}
public void setTriviaAnswerFour(String triviaAnswerFour) {
	this.triviaAnswerFour = triviaAnswerFour;
}
public String getTriviaAnswerFive() {
	return triviaAnswerFive;
}
public void setTriviaAnswerFive(String triviaAnswerFive) {
	this.triviaAnswerFive = triviaAnswerFive;
}

}
