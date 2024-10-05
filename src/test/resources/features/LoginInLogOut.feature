  #language: en
  #encoding:UTF-8

  @userSession
  Feature: LoginAndLogoutFunctionality

    Scenario: Successful Login And Logout
      Given user navigates to the demo login page
      When user enters their credentials
      And user clicks the "Sign in" button
      Then user should see the "Choose product" button
      When user chooses the Eyes product
      Then user should see their profile button
      And user clicks the profile button
      When user clicks the "Log  out" button
      Then user should see the Authorization page