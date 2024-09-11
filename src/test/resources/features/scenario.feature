  #language: en
  #encoding:UTF-8

  @UserSession
  Feature: LoginAndLogoutFunctionality

    Scenario: Successful Login And Logout
      Given the user navigates to the demo login page
      When the user enters their credentials
      And the user clicks the "Sign in" button
      Then the user should see the "Choose product" button
      When the user chooses the Eyes product
      Then the user should see their profile button
      And the user clicks the profile button
      When the user clicks the "Log  out" button
      Then the user should see the Authorization page


