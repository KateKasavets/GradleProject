#language: en
# encoding:UTF-8

@login
Feature: Successful user log in to battle.net website

  Scenario Outline: Successful Login
    Given user navigates to "https://eu.account.battle.net"
    When user enters "<login>" and "<password>"
    Then user should see title "Обзор учетной записи"

    Examples:
      | login                           | password  |
      | evinasenla@gmail.com            | kk25474kk |
      | catharinekosovets2189@gmail.com | kk25474kk |