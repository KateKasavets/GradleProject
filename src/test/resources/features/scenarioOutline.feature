#language: en
# encoding:UTF-8

@login
Feature: Users Login to Battlnet

  Scenario Outline: Successful Login
    Given the user navigates to "https://eu.account.battle.net"
    When the user enters "<login>" and "<password>"
    Then the user should see title "<expectedTitle>"

    Examples:
      | login                           | password  | expectedTitle        |
      | evinasenla@gmail.com            | kk25474kk | Обзор учетной записи |
      | catharinekosovets2189@gmail.com | kk25474kk | Обзор учетной записи |