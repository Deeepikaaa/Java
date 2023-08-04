package com.bdd.bddscenario.integration;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CucumberSpringIntegration {

	protected static ResponseResults latestResponse = null;
	
	protected RestTemplate restTemplate = new RestTemplate();

	protected ErrorHandler errorHandler = new ErrorHandler();

	protected static String baseurl = "http://localhost:8082";

	public void executeSearch(String url, String userName, String password, Boolean access)
			throws IOException, JSONException {

		// create request body
		JSONObject request = new JSONObject();
		request.put("userName", userName);
		request.put("password", password);
		request.put("authentication", access);

		// set headers
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
		// HttpEntity<String> entity = new HttpEntity<String>(request.toString(),
		// headers);

		// send request and parse result
//		try {
//		loginResponse = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}

		final Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers,
				request.toString());

		restTemplate.setErrorHandler(errorHandler);
		latestResponse = restTemplate.execute(url, HttpMethod.POST, requestCallback, response -> {
			System.out.println(response);
			if (errorHandler.hadError) {
				System.out.println(errorHandler.hadError);
				return errorHandler.getError();
			}
			else {
				
				System.out.println(response);
				return new ResponseResults(response);
			}
		});
	}

	public class ErrorHandler implements ResponseErrorHandler {
		private ResponseResults errorResults = null;
		private boolean hadError = false;

		public ResponseResults getError() {
			return errorResults;
		}

		@Override
		public boolean hasError(ClientHttpResponse response) throws IOException {
			hadError = response.getStatusCode().value() >= 400;
			return hadError;
		}

		@Override
		public void handleError(ClientHttpResponse response) throws IOException {
			errorResults = new ResponseResults(response);

		}

	}

}
