Feature: Kudo Creation via Recognition Form

  As a Sofkiano
  I want to fill out and submit the recognition form
  So that a new Kudo is created and registered in the system

  @E2E @CreateKudo
  Scenario Outline: Successfully submit the Kudo form with valid data
    Given the Sofkiano is on the Kudos recognition form
    When they send a Kudo recognizing a colleague with from "<from>", recipient "<recipient>", category "<category>", and message "<message>"
    Then the Kudo should be successfully registered

    Examples:
      | from     | recipient         | category | message      |
      | Santiago | Christopher Pallo | Teamwork | Buen trabajo |