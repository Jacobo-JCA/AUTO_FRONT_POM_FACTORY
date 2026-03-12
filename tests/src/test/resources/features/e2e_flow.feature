Feature: E2E Flow from Landing to Kudos Page

  @E2E
  Scenario Outline: User is redirected to the Kudos form from the landing page
    Given the user is on the Landing Hero page
    When the user completes the landing page slider
    Then the Kudos form page should be displayed with title "<expectedTitle>"
    And the recognition form should be visible

    Examples:
      | expectedTitle |
      | Reconoce      |