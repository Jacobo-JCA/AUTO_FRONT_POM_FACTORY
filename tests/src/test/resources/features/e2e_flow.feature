Feature: E2E Flow from Landing to Kudos Page

  @E2E
  Scenario Outline: Redirect to the Kudos form from the home page
    Given that the Sofkiano is on the home page
    When they complete the slider in the Hero section
    Then they should see the Kudos form with the title "<expectedTitle>"
    And the recognition form should be visible for interaction

    Examples:
      | expectedTitle |
      | Reconoce      |