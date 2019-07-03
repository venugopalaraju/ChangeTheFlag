package com.epam.hackme.validator;

import org.springframework.validation.BindingResult;

import com.epam.hackme.common.PasswordConstants;
import com.epam.hackme.dto.Trivia;

public class HackMeValidator {

	public static BindingResult validTriviaChallenges(Trivia trivia,BindingResult result) {
		if(!PasswordConstants.TRIVIA_ANSWER_ONE.equalsIgnoreCase(trivia.getTriviaAnswerOne())) {
			result.rejectValue("triviaAnswerOne","",PasswordConstants.WRONG);
		}
		if(!PasswordConstants.TRIVIA_ANSWER_TWO.equalsIgnoreCase(trivia.getTriviaAnswerTwo())) {
			result.rejectValue("triviaAnswerTwo","",PasswordConstants.WRONG);
		}
		if(!PasswordConstants.TRIVIA_ANSWER_THREE.equalsIgnoreCase(trivia.getTriviaAnswerThree())) {
			result.rejectValue("triviaAnswerThree","",PasswordConstants.WRONG);
		}
		if(!PasswordConstants.TRIVIA_ANSWER_FOUR.equalsIgnoreCase(trivia.getTriviaAnswerFour())) {
			result.rejectValue("triviaAnswerFour","",PasswordConstants.WRONG);
		}
		if(!PasswordConstants.TRIVIA_ANSWER_FIVE.equalsIgnoreCase(trivia.getTriviaAnswerFive())) {
			result.rejectValue("triviaAnswerFive","",PasswordConstants.WRONG);
		}
		return result;
	}
	
	public static int validTriviaChallenges(Trivia trivia) {
		int score=0;
		if(PasswordConstants.TRIVIA_ANSWER_ONE.equalsIgnoreCase(trivia.getTriviaAnswerOne())) {
			score=score+1;
		}
		if(PasswordConstants.TRIVIA_ANSWER_TWO.equalsIgnoreCase(trivia.getTriviaAnswerTwo())) {
			score=score+1;
		}
		if(PasswordConstants.TRIVIA_ANSWER_THREE.equalsIgnoreCase(trivia.getTriviaAnswerThree())) {
			score=score+1;
		}
		if(PasswordConstants.TRIVIA_ANSWER_FOUR.equalsIgnoreCase(trivia.getTriviaAnswerFour())) {
			score=score+1;
		}
		if(PasswordConstants.TRIVIA_ANSWER_FIVE.equalsIgnoreCase(trivia.getTriviaAnswerFive())) {
			score=score+1;
		}
		return score;
	}
}
