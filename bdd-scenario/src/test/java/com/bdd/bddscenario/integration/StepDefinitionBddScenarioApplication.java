package com.bdd.bddscenario.integration;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.springframework.http.HttpStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionBddScenarioApplication extends CucumberSpringIntegration {

	private String userName;
	private String password;
	private Boolean access;

	// @ParameterType(value = "true|True|TRUE|false|False|FALSE")
	@When("user enters {string} ,{string} and {string}")
	public void user_enters_and_true(String username, String pw, String accessed) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		userName = username;
		password = pw;
		access = Boolean.valueOf(accessed);
		String url = baseurl + "/user/signin";
		executeSearch(url, userName, password, access);
		// throw new io.cucumber.java.PendingException();
	}

	@Then("user receives response {int}")
	public void user_receives_response(Integer statusCode) throws Throwable {

		System.out.println(latestResponse);
		HttpStatus currentStatusCode = latestResponse.getStatusCode();
		System.out.println(currentStatusCode.value());
		// assertEquals(currentStatusCode.value(), status);
		MatcherAssert.assertThat("HttpStatusCode is incorrect : " + latestResponse.getBody(), currentStatusCode.value(),
				Matchers.equalTo(statusCode));
	}

	@Then("user receivs message {string}")
	public void user_receivs_message(String message) throws Throwable {
		String currentMessage = latestResponse.getBody();
		MatcherAssert.assertThat("HttpStatusCode is incorrect : " + latestResponse.getBody(), currentMessage,
				Matchers.equalTo(message));
	}

}
