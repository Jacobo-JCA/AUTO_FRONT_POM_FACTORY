package com.automation.stepdefinitions;

import com.automation.tasks.E2EUiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class E2EStepDefinitions {
    @Steps
    E2EUiSteps e2eUiSteps;

    @Given("the user is on the Landing Hero page")
    public void theUserIsOnTheLandingHeroPage() {
        e2eUiSteps.openLanding();
    }

    @When("the user completes the landing page slider")
    public void theUserCompletesTheLandingPageSlider() {
        e2eUiSteps.completeSlider();
    }

    @Then("the Kudos form page should be displayed with title {string}")
    public void theKudosFormPageShouldBeDisplayed(String expectedTitle) {
        e2eUiSteps.validateKudosPageWithTitle(expectedTitle);
    }

    @Then("the recognition form should be visible")
    public void theRecognitionFormShouldBeVisible() {
        e2eUiSteps.validateKudosForm();
    }
}