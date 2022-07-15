/*package com.springbootproject.firstspringbootproject;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springbootproject.firstspringbootproject.DriverClasses.Question;
import com.springbootproject.firstspringbootproject.service.SurveyService;

@ExtendWith(SpringExtension.class)
@WithMockUser(username = "user1", password = "secret1",roles= {"ADMIN","USER"})
public class SurveyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// Mock @Autowired
	@MockBean
	private SurveyService surveyService;

	@Test
	public void retrieveDetailsForQuestion() throws Exception {
		Question mockQuestion = new Question(1,"Largest Country in the World", "Russia", "India", "Russia", "United States", "China");

		Mockito.when(
				surveyService.retrieveQuestion(Mockito.anyInt(), Mockito
						.anyInt())).thenReturn(mockQuestion);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/surveys/1/questions/Question1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{id:Question1,description:\"Largest Country in the World\",correctAnswer:Russia}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

		// Assert
	}

	@Test
	public void createSurveyQuestion() throws Exception {
		Question mockQuestion = new Question(1, "Smallest Number", "1","1", "2", "3", "4");

		String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
		//surveyService.addQuestion to respond back with mockQuestion
		Mockito.when(
				surveyService.addQuestion(Mockito.anyInt(), Mockito
						.any(Question.class))).thenReturn(mockQuestion);

		//Send question as body to /surveys/Survey1/questions
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/surveys/1/questions")
				.accept(MediaType.APPLICATION_JSON).content(questionJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/surveys/1/questions/1", response
				.getHeader(HttpHeaders.LOCATION));
	}
}*/