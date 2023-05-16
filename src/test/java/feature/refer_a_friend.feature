Feature: refer_a_friend
  @refer_a_friend
  Scenario: As a registered user, I should able to refer a product to a friend
  successfully
  Given I am a registered user
  When I log in
  And I enter required log in details
  And I add Apple Mac Book in cart
  And I click on email a friend
  And I enter required details
  Then I should able to refer a product successfully
