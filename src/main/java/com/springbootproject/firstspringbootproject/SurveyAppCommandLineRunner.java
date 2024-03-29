package com.springbootproject.firstspringbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springbootproject.firstspringbootproject.DriverClasses.Question;
import com.springbootproject.firstspringbootproject.DriverClasses.Survey;
import com.springbootproject.firstspringbootproject.DriverClasses.User;
import com.springbootproject.firstspringbootproject.repository.QuestionsRepository;
import com.springbootproject.firstspringbootproject.repository.SurveyRepository;
import com.springbootproject.firstspringbootproject.repository.UserRepository;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component //At startup to initialize things
public class SurveyAppCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory
			.getLogger(SurveyAppCommandLineRunner.class);
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private QuestionsRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Question question1 = new 
				Question(1,"What is the type of database that holds only one type of information: ", "Field", "Report", "File", "Field", "Record");
		Question question2 = new 
				Question(2,"'.MOV' extension refers to: ", "Animation/movie file","Image file", "Animation/movie file", "Audio file", "MS Office document");
		Question question3 = new 
				Question(3, "Highest GDP in the World", "United States","India", "Russia", "United States", "China");
		Question question4 = new 
				Question(4,"The purpose of choke in tube light is: ", "To increase the voltage momentarily","To decrease the current", "To increase the current", "To decrease the voltage momentarily", "To increase the voltage momentarily");
		
		surveyRepository.save(new Survey(1, "laasya","On Springboot",
				questionRepository.saveAll(Arrays.asList(question1,question2))));
		surveyRepository.save(new Survey(2, "ram","On Springboot App",
				questionRepository.saveAll(Arrays.asList(question3,question4))));
		log.info("Surveys are.....");
		for (Survey survey : surveyRepository.findAll()) {
			log.info(survey.toString());
		}
		log.info("____________________");
		log.info("Admin users are.....");
		userRepository.save(new User(1, "Ranga", "Admin", "ranga"));
		userRepository.save(new User(2, "Ravi", "User", "ravi"));
		userRepository.save(new User(3, "Satish", "Admin", "satish"));
		userRepository.save(new User(4, "Raghu", "User", "raghu"));
		for (User user : userRepository.findAll()) {
			log.info(user.toString());
		}
		log.info("____________________");
	}
	
	

}
