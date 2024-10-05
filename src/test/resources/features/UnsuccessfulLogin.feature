#language: en
#encoding:UTF-8

@negative
Feature: Unsuccessful attempt to log in and then switch to registration

  Background:
    Given user navigates to the demo page

  Scenario: Login with invalid password
    When user attempts to log in with email "evinasenla@gmail.com" and invalid password "invalidPassword123"
    Then user should see an error message "Incorrect username or password."

  Scenario: Login with invalid email
    When user attempts to log in with invalid email "evinasenlaaaa@gmail.com" and password "kk25474kkKK!"
    Then user should see an error message "Incorrect username or password."

  Scenario: Login with invalid email format
    When user attempts to log in with invalid email format "evinasenla@gmail.com12" and password "kk25474kkKK!"
    Then user should see an error message "Please enter a valid email"

  Scenario: Navigation to registration page
    When user clicks "Try now" button
    Then user should see the registration page
