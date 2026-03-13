package com.automation.stepdefinitions;

import com.automation.tasks.VerifyKudoInList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class KudoListStepDefinitions {
    @Steps
    VerifyKudoInList verifyKudoInList;
    private String from;
    private String recipient;
    private String category;

    @Given("the Sofkiano navigates to the Kudos list page")
    public void theSofkianoNavigatesToTheKudosListPage() {
        verifyKudoInList.navigateToList();
    }

    @Then("the list should display a Kudo from {string} to {string}")
    public void theListShouldDisplayAKudoFromTo(String from, String recipient) {
        this.from = from;
        this.recipient = recipient;
    }

    @And("the Kudo should show the category {string}")
    public void theKudoShouldShowTheCategory(String category) {
        this.category = category;
    }

    @And("the Kudo should show the message {string}")
    public void theKudoShouldShowTheMessage(String message) {
        verifyKudoInList.verifyKudoExists(from, recipient, category, message);
    }
}