package com.automation.stepdefinitions;

import com.automation.tasks.FillAndSubmitKudoForm;
import com.automation.tasks.VerifyKudoCreation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class KudoCreationStepDefinitions {
    @Steps
    FillAndSubmitKudoForm fillAndSubmitKudoForm;
    @Steps
    VerifyKudoCreation verifyKudoCreation;

    @Given("the Sofkiano is on the Kudos recognition form")
    public void theSofkianoIsOnTheKudosRecognitionForm() {
        fillAndSubmitKudoForm.navigateToForm();
    }

    @When("they send a Kudo recognizing a colleague with from {string}, recipient {string}, category {string}, and message {string}")
    public void theySendAKudoRecognizingAColleague(String from, String recipient, String category, String message) {
        fillAndSubmitKudoForm.withData(from, recipient, category, message);
    }

    @Then("the Kudo should be successfully registered")
    public void theKudoShouldBeSuccessfullyRegistered() {
        verifyKudoCreation.isSuccessful();
    }
}