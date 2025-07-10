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
@LoginTag
Feature: Facebook login  feature
  I want to use this template for my login feature file

  @tag1
  Scenario: Valid Login scenario
    Given I am the user of facebook application
    When I enter my valid username
    And I enter my valid password
    And I click on Login button
    Then I should be able to login successfully.
   

  @tag2
  Scenario : InValid Login scenario
     Given I am the user of facebook application
    When I enter my invalid username
    And I enter my invalid password
    And I click on Login button
    Then I should not  be able to login successfully.
    And  Error message should be display
   