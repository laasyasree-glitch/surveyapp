package com.springbootproject.firstspringbootproject;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springbootproject.firstspringbootproject.jpa.SurveyRepository;
import com.springbootproject.firstspringbootproject.jpa.UserRepository;

@Component
@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
/*	private static List<Survey> surveys = new ArrayList<>();
	static {
		Question question1 = new 
				Question(1,"Largest Country in the World", "Russia", "India", "Russia", "United States", "China");
		Question question2 = new 
				Question(2,"Most Populus Country in the World", "China","India", "Russia", "United States", "China");
		Question question3 = new 
				Question(3, "Highest GDP in the World", "United States","India", "Russia", "United States", "China");
		Question question4 = new 
				Question(4,"Second largest english speaking country", "India","India", "Russia", "United States", "China");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1,
				question2, question3, question4));

		Survey survey = new Survey(1, "My Favorite Survey",
				"Description of the Survey", questions);

		surveys.add(survey);
	}
*/
	public List<Survey> retrieveAllSurveys() {
		List<Survey> surveys = new ArrayList<>();
		surveyRepository.findAll().forEach(surveys::add);
		return surveys;
	}

	public Survey retrieveSurvey(int surveyId) {
		Optional<Survey> optionSurvey =surveyRepository.findById(surveyId);
		
			if (optionSurvey.isPresent()) {
				return optionSurvey.get();
			}
		return null;
	}

	public List<Question> retrieveQuestions(int surveyId) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		return survey.getQuestions();
	}

	public Question retrieveQuestion(int surveyId, int questionId) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		for (Question question : survey.getQuestions()) {
			if (question.getId()==(questionId)) {
				return question;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Question addQuestion(int surveyId, Question question) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		BigInteger randomId = new BigInteger(130, random);
		question.setId(randomId.intValue());

		survey.getQuestions().add(question);

		return question;
	}
}