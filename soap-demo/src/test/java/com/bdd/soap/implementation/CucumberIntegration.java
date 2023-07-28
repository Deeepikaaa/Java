package com.bdd.soap.implementation;

import com.bdd.soap.stubs.AddTwoNumbers;

import com.bdd.soap.stubs.AddTwoNumbersService;

public class CucumberIntegration {

	AddTwoNumbersService service;
	AddTwoNumbers webmethod;
	int result = 0;

	public void getNumbers(int a, int b) {
		service = new AddTwoNumbersService();
		webmethod = service.getAddTwoNumbers();
		result = webmethod.addNumbers(a, b);
	}
}



