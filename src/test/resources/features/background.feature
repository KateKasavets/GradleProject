  #language: en
  #encoding:UTF-8

  @negative
  Feature: Unsuccessful attempt to log in and then switch to registration

    Background:
      Given the user is on the login page

    Scenario: Login with invalid password
      When the user attempts to login with invalid password
      Then the user should see an error message "Incorrect username or password."

    Scenario: Navigation to registration page
      When the user clicks "Try now" button
      Then the user should see the registration page

