@logIn
Feature: Login functionality

  Acceptance Criteria:
  As a user, I want to be able to Login

  @positive
  Scenario: I login with correct information
    Given I tap on Login as Employee button
    And I tap on Log In button
    When I enter "admin@endava.com" as login email
    And I enter "admin" as login password
    And I tap on Sign In button
    Then I should see that I am correctly logged in

  @negative
  Scenario: I try to log with different than Endava mail
    Given I tap on Login as Employee button
    And I tap on Log In button
    When I enter "mail@notEndava.com" as login email
    And I enter "admin" as login password
    And I tap on Sign In button
    Then I should see Wrong Email Error message displayed


#  val VALID_EMAIL = "admin@endava.com"
#  val VALID_PASSWORD = "admin"
#  val SHORT_PASSWORD = "1234"
#  val LONG_PASSWORD = "12345678901234567890123456789012345678901234567890z" // 51
#
#  /**
#    * test sign in (all error cases + success afterwards)
#  */
#  // wait login screen to show up
#
#  // 1. case empty fields
#  // click the login button
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
#  // 5. case wrong password
#  // fill in the fields
#
#  // click the login button
#
#  // wait for error
#
#  // 6. case successful login
#  // fill in the fields
#
#  // click the login button
#
#  // wait for home screen (category screen)
#  }
#
#  /**
#    * test categories list and all offers
#  */
#  // wait for home screen (category screen) to show up
#
#  // 1. case all offers
#  // click the all offers button
#
#  // wait for benefits list
#
#  // click on first offer
#
#  // go back to benefits list
#
#  // go back to categories
#
#  // 2. case first available category + test a benefit
#  // click on first ЦЪК-able (ЩРАК-able) category
#
#  // click on first offer
#
#  // test the benefit
#
#  // go back to benefits list
#
#  // go back to categories
#  }
#
#  /**
#    * test a single benefit
#  */
#  // wait for benefit screen (offer details screen) to show up
#
#
#  // 1. rate with the lowest possible rating
#  // click on the rating bar to show dialog
#
#  // wait for rating dialog to show up
#
#  // set rating of 1
#
#  // click on the button
#
#  // wait for rating dialog close
#
#
#  // 2. rate second time with the highest rating
#  // click on the rating bar to show dialog
#
#  // wait for rating dialog to show up
#
#  // set rating of 5
#
#  // click on the button
#
#  // wait for rating dialog close
#
#  // rateButton, ratingBar
#
#  // open digital ID
#  // wait for the ID to open
#  // close digital ID
#  }