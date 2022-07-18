//package com.springbootproject.firstspringbootproject;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.nio.charset.Charset;
//import java.util.Arrays;
//import java.util.List;
//
//import org.json.JSONException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.codec.Base64;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.springbootproject.firstspringbootproject.DriverClasses.Question;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SurveyControllerIT {
//
//	@LocalServerPort
//	private int port;
//
//	TestRestTemplate restTemplate = new TestRestTemplate();
//
//	HttpHeaders headers = new HttpHeaders();
//
//	@BeforeEach
//	public void before() {
//		headers.add("Authorization", createHttpAuthenticationHeaderValue(
//				"user1", "secret1"));
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	}
//
//	@Test
//	public void testRetrieveSurveyQuestion() throws JSONException {//Body of the question format
//
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/surveys/1/questions/1"),
//				HttpMethod.GET, entity, String.class);
//
//		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
//
//		JSONAssert.assertEquals(expected, response.getBody(), false);
//	}
//
//	@Test
//	public void retrieveAllSurveyQuestions() throws Exception {//Contains question
//
//		ResponseEntity<List<Question>> response = restTemplate.exchange(
//				createURLWithPort("/surveys/1/questions"),
//				HttpMethod.GET, new HttpEntity<String>("DUMMY_DOESNT_MATTER",
//						headers),
//				new ParameterizedTypeReference<List<Question>>() {
//				});
//
//		Question sampleQuestion = new Question(1,
//				"Largest Country in the World", "Russia", 
//						"India", "Russia", "United States", "China");
//		System.out.println(response.getBody());
//		assertTrue(response.getBody().contains(sampleQuestion));
//	}
//
//	@Test
//	public void addQuestion() {
//
//		Question question = new Question(1, "DOESNTMATTER", "Russia",
//				"India", "Russia", "United States", "China");
//
//		HttpEntity entity = new HttpEntity<Question>(question, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/surveys/1/questions"),
//				HttpMethod.POST, entity, String.class);
//
//		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//
//		assertTrue(actual.contains("/surveys/1/questions/"));
//
//	}
//	
//	private String createURLWithPort(final String uri) {
//		return "http://localhost:" + port + uri;
//	}
//
//	private String createHttpAuthenticationHeaderValue(String userId,
//			String password) {
//		//userID, password, Basic
//		//"Authorization","Basic" +Base64Encoding(userId+":"+password)
//		String auth = userId + ":" + password;
//
//		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
//				.forName("US-ASCII")));
//
//		String headerValue = "Basic " + new String(encodedAuth);
//
//		return headerValue;
//	}
//
//}