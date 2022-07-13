package com.springbootproject.firstspringbootproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.springbootproject.firstspringbootproject.DriverClasses.Question;
import com.springbootproject.firstspringbootproject.DriverClasses.Survey;
import com.springbootproject.firstspringbootproject.repository.SurveyRepository;

@Component
@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
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


	public Question addQuestion(int surveyId, Question question) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		survey.getQuestions().add(question);
		surveyRepository.save(survey);
		System.out.println(question);
		return question;
	}
}