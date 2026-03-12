package com.automation.tasks;

import com.automation.ui.LandingPage;
import com.automation.ui.KudosPage;
import net.serenitybdd.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class E2EUiSteps {
    LandingPage landingPage;
    KudosPage kudosPage;

    @Step("Open the Landing Page")
    public void openLanding() {
        landingPage.open();
    }

    @Step("Complete the slider on the Landing Page")
    public void completeSlider() {
        landingPage.launchApp();
    }

    @Step("Validate that the Kudos page is displayed with title: {0}")
    public void validateKudosPageWithTitle(String expectedTitle) {
        kudosPage.waitForCondition().until(
                driver -> kudosPage.getTitle().contains(expectedTitle)
        );
        assertThat(kudosPage.getTitle()).contains(expectedTitle);
    }

    @Step("Validate that the Kudos form is visible")
    public void validateKudosForm() {
        assertThat(kudosPage.isKudoFormVisible()).isTrue();
    }
}
