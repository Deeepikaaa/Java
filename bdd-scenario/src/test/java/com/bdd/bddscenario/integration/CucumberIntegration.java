package com.bdd.bddscenario.integration;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features" , glue= {"com.bdd.bddscenario.integration"}, plugin = {"pretty", "html:target/cucumber-report.html"})
public class CucumberIntegration {

}
