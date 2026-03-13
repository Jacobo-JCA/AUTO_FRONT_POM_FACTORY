package com.automation.tasks;

import com.automation.page.KudoFormPage;
import com.automation.page.components.KudoForm;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FillAndSubmitKudoForm {
    private KudoFormPage kudoFormPage;
    private KudoForm kudoForm;

    @Step("Navigate to the Kudo recognition form")
    public void navigateToForm() {
        kudoFormPage.open();
        assertThat(kudoFormPage.isReady())
                .as("Kudo form should be visible after navigation")
                .isTrue();
    }

    @Step("Fill and submit the Kudo form from: {0}, recipient: {1}, category: {2}, message: {3}")
    public void withData(String from, String recipient, String category, String message) {
        kudoForm.selectFromUser(from);
        kudoForm.selectToUser(recipient);
        kudoForm.selectCategory(category);
        kudoForm.writeMessage(message);
        kudoForm.submitBySlider();
    }
}
