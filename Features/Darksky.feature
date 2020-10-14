Feature:  darksky whether page testing (darksky.net - whether forecasting website https://darksky.net/forecast/28.627,77.2154/us12/en )

#1
  @verifyTemperature
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky Home Page
    Then I verify current temp is not greater or less then temps from daily timeline


#2
  Scenario: Verify timeline is displayed in correct format
    Given I am on Darksky Home Page
    Then I verify timeline is displayed with two hours incremented


#3
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    Then I verify todays lowest and highest temp is displayed correctly


#4
  Scenario: Verify invalid error message on Login Page
    Given I am on the darksky Login page
    When I click on Login button
    Then I verify I am on Login page by asserting Login page title