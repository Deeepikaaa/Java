package com.bdd.soap.implementation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import io.cucumber.java.en.Given;

public class StepDefinitions extends CucumberIntegration {

	@Given("I enter two numbers {int} and {int}")
	public void i_enter_two_numbers_and(Integer int1, Integer int2) {
		getNumbers(int1, int2);

	}

	@Given("the addition value should be {int}")
	public void the_addition_value_should_be(Integer value) {
		MatcherAssert.assertThat(result, CoreMatchers.equalTo(value));
	}
}
