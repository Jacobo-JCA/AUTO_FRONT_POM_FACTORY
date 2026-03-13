package com.automation.tasks;

import com.automation.page.KudoListPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyKudoInList {
    private KudoListPage kudosListPage;

    @Step("Navigate to the Kudos list page")
    public void navigateToList() {
        kudosListPage.open();
        assertThat(kudosListPage.isReady())
                .as("Kudos list page should be visible")
                .isTrue();
    }

    @Step("Verify Kudo from {0} to {1} with category {2} and message {3} exists in the list")
    public void verifyKudoExists(String from, String recipient, String category, String message) {
        assertThat(kudosListPage.hasKudoWith(from, recipient, category, message))
                .as("Kudo should be visible in the list")
                .isTrue();
    }
}
