Feature: Test

  Scenario: Test
    Given I am on booking home page
    When I change language to "Srpski"
    And I add destination "Kopaonik"
    And I add start and end date "15 decembar 2021" "18 decembar 2021"
    And I add accommodation
    And I click search button "Trazi"
    And I should see results
    And I click filter
    And I click a hotel button
    Then I am on redirected page




