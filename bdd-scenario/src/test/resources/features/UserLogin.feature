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
Feature: Authenticate User
User needs to be authenticated based on entered credentials and okta verification

@tag1
 Scenario Outline: user entered correct credentials and okta verified
     When user enters "<Username>" ,"<Password>" and "<Authenticated>"
     Then user receives response 200 
     Then user receivs message "Valid User and access granted"   
     
    
      
     Examples: 
       | Username | Password    |  Authenticated  |
       | Deepika  |  Deepika123 |   true          | 
        
 
@tag2       
 Scenario Outline: user entered correct credentials and okta not verified
     When user enters "<Username>" ,"<Password>" and "<Authenticated>"
     Then user receives response 403
     Then user receivs message "Okta verification neeeded"   
     
    
      
     Examples: 
       | Username | Password    |  Authenticated  |
       | Deepika  |  Deepika123 |   false         | 
         

@tag3       
 Scenario Outline: user entered wrong credentials
     When user enters "<Username>" ,"<Password>" and "<Authenticated>"
     Then user receives response 400
     Then user receivs message "Invalid Username or password"   
     
    
      
     Examples: 
       | Username | Password    |  Authenticated  |
       | Deepika  |  Deepika23  |   false         |       
