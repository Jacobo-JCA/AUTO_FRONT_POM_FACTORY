Feature: Kudo Listing and Persistence Verification

  As a Sofkiano
  I want to navigate to the Kudos list page
  So that I can verify that recently created Kudos are stored correctly

  @E2E @ListKudos
  Scenario Outline: Verify a created Kudo appears in the Kudos list
    Given the Sofkiano navigates to the Kudos list page
    Then the list should display a Kudo from "<from>" to "<recipient>"
    And the Kudo should show the category "<category>"
    And the Kudo should show the message "<message>"

    Examples:
      | from              | recipient         | category   | message                                      |
      | Christopher Pallo | Santiago          | Innovation | Excelente colaboración en el sprint          |
      | Santiago          | Frontend Team     | Teamwork   | Gran propuesta técnica para el pipeline      |
      | Frontend Team     | Christopher Pallo | Passion    | Apoyo constante al equipo durante la entrega |