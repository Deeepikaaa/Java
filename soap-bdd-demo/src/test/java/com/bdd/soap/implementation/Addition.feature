#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Adding two numbers
 

  @tag1
  Scenario Outline: Providing two numbers to get the addition value
    Given the numbers are <num1> and <num2>
    And the addition value should be <result>
    
    Examples:
    | num1 | num2 | result |
    | 1    | 2    | 3      |
    | 8    | 10   | 18     |
    
   

  