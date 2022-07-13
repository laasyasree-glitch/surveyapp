package com.springbootproject.firstspringbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.firstspringbootproject.DriverClasses.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey,Integer>{
	//get all questions
	//get specific question
	//add a question
	
	
}