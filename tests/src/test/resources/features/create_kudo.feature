Feature: Kudo Creation via Recognition Form

  As a Sofkiano
  I want to fill out and submit the recognition form
  So that a new Kudo is created and registered in the system

  @E2E @CreateKudo
  Scenario Outline: Successfully submit the Kudo form with valid data
    Given the Sofkiano is on the Kudos recognition form
    When they send a Kudo recognizing a colleague with the following details
      | from   | recipient   | category   | message   |
      | <from> | <recipient> | <category> | <message> |
    Then the Kudo should be successfully registered

    Examples:
      | from              | recipient         | category   | message                                      |
      | Christopher Pallo | Santiago          | Innovation | Excelente colaboración en el sprint          |
      | Santiago          | Frontend Team     | Teamwork   | Gran propuesta técnica para el pipeline      |
      | Frontend Team     | Christopher Pallo | Passion    | Apoyo constante al equipo durante la entrega |