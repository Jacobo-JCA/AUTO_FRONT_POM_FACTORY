package com.automation.stepdefinitions;

import com.automation.tasks.E2EUiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class E2EStepDefinitions {
    @Steps
    E2EUiSteps e2eUiSteps;

    @Given("that the Sofkiano is on the home page")
    public void thatTheSofkianoIsOnTheHomePage() {
        e2eUiSteps.openLanding();
    }

    @When("they complete the slider in the Hero section")
    public void theyCompleteTheSliderInTheHeroSection() {
        e2eUiSteps.completeSlider();
    }

    @Then("they should see the Kudos form with the title {string}")
    public void theyShouldSeeTheKudosFormWithTheTitle(String expectedTitle) {
        e2eUiSteps.validateKudosPageWithTitle(expectedTitle);
    }

    @Then("the recognition form should be visible for interaction")
    public void theRecognitionFormShouldBeVisibleForInteraction() {
        e2eUiSteps.validateKudosForm();
    }
}
