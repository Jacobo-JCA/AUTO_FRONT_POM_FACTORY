package com.automation.stepdefinitions;

import com.automation.tasks.FillAndSubmitKudoForm;
import com.automation.tasks.VerifyKudoCreation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

import java.util.Map;

public class KudoCreationStepDefinitions {
    @Steps
    FillAndSubmitKudoForm fillAndSubmitKudoForm;
    @Steps
    VerifyKudoCreation verifyKudoCreation;

    @Given("the Sofkiano is on the Kudos recognition form")
    public void theSofkianoIsOnTheKudosRecognitionForm() {
        fillAndSubmitKudoForm.navigateToForm();
    }

    @When("they send a Kudo recognizing a colleague with the following details")
    public void theySendAKudoRecognizingAColleague(DataTable kudoDetailsTable) {
        Map<String, String> kudoData = kudoDetailsTable.asMaps().get(0);
        fillAndSubmitKudoForm.withData(
                kudoData.get("from"),
                kudoData.get("recipient"),
                kudoData.get("category"),
                kudoData.get("message")
        );
    }

    @Then("the Kudo should be successfully registered")
    public void theKudoShouldBeSuccessfullyRegistered() {
        verifyKudoCreation.isSuccessful();
    }
}
