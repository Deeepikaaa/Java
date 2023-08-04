package com.bdd.soap.implementation;

import java.io.IOException;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import io.cucumber.java.en.Given;

public class StepDefinitions extends CucumberIntegration {

	@Given("the numbers are {int} and {int}")
	public void the_numbers_are_and(Integer int1, Integer int2) throws IOException {
		getNumbers(int1, int2);
	}

	@Given("the addition value should be {int}")
	public void the_addition_value_should_be(Integer value) {
		MatcherAssert.assertThat(result, CoreMatchers.equalTo(value));
	}

}
