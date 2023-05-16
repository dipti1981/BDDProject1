Feature: register
  @register
  Scenario: As a user, I should abele to register successfully
    so that, I can use all user feature
    Given  I am on registration page
    When  I enter required registration details
    Then I should able to register successfully