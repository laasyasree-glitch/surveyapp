package com.springbootproject.firstspringbootproject.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.springbootproject.firstspringbootproject.DriverClasses.Question;
import com.springbootproject.firstspringbootproject.repository.SurveyRepository;import com.springbootproject.firstspringbootproject.service.SurveyService;

@RestController //No need to use @ResponseBody
public class SurveyController {
	
	@Autowired
	SurveyRepository repository1;
	
	@Autowired
	private SurveyService surveyService;
	
	
	@GetMapping("/surveys/{surveyId}/questions")
	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	public List<Question> retriveQuestionForSurvey(@PathVariable int surveyId, ModelMap model){
		return surveyService.retrieveQuestions(surveyId);
		//return surveyRepository.findByQuestionId(surveyId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	@PreAuthorize("hasAuthority('Admin')")
    ResponseEntity<?> add(@PathVariable int surveyId,
            @RequestBody Question question) {

        Question createdTodo = surveyService.addQuestion(surveyId, question);
		//Question createdTodo = surveyRepository.save(surveyId, question);
        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();   //Developing url for new question

        return ResponseEntity.created(location).build();

    }
    
    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    @PreAuthorize("hasAnyAuthority('Admin', 'User')")
	public Question retriveQuestion(@PathVariable int surveyId,@PathVariable int questionId ){
		
		return surveyService.retrieveQuestion(surveyId,questionId);
    	//return surveyRepository.findSpecificQuestion(surveyId,questionId);
	}

}
