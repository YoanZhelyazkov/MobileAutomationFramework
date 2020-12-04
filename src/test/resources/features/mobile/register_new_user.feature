@register
Feature: Register functionality

  Acceptance Criteria:
  As a user, I want to be able to Register a new user

  Scenario: I register with correct information
    Given I tap on Login as Employee button
    And I tap on Create new User button
    When I Enter "dummy@endava.com" as Register Email
    And I Enter "blabla" as Register Password
    And I Enter "blabla" as Register Confirm Password
    And I tap on the register button
    Then I should see Notification message "You must complete your registration from the confirmation link sent on your e-mail."


#  val VALID_EMAIL = "admin@endava.com"
#  val VALID_PASSWORD = "admin"
#  val SHORT_PASSWORD = "1234"
#  val LONG_PASSWORD = "12345678901234567890123456789012345678901234567890z" // 51

  #  /**
#    * test sign up (all error cases + success afterwards)
#  */
#
#  // 1. case empty fields
#  // click the register button
#  // wait for error
#
#  // 2. case non-endava email
#  // fill in the fields
#  // click the login button
#  // wait for error
#
#  // 3. case password less than or equal to 4 characters
#  // fill in the fields
#  // click the login button
#  // wait for error
#
#  // 4. case password longer than 50 characters
#  // fill in the fields
#  // click the login button
#  // wait for error
#
#  // 5. case passwords do not match
#  // fill in the fields
#  // click the login button
#  // wait for error
#
#  // 6. case existing loser
#  // fill in the fields
#  // click the login button
#  // wait for home screen (category screen)
#
#  // 7. case successful register
#  // fill in the fields
#  // click the login button
#  // wait for home screen (category screen)
#
#