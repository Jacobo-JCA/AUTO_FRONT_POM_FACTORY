package com.automation.tasks;

import com.automation.page.KudoFormPage;
import com.automation.page.components.KudoForm;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FillAndSubmitKudoForm {

    KudoFormPage kudoFormPage; // package-private: Serenity inyecta PageObjects automáticamente en @Steps
    KudoForm kudoForm;

    @Step("Navegar al formulario de reconocimiento de Kudos")
    public void navigateToForm() {
        kudoFormPage.open();
        assertThat(kudoFormPage.isReady())
                .as("El formulario de Kudos debería estar visible al navegar")
                .isTrue();
    }

    @Step("Completar y enviar el formulario: de={0}, para={1}, categoría={2}, mensaje='{3}'")
    public void withData(String from, String recipient, String category, String message) {
        kudoForm.selectFromUser(from);
        kudoForm.selectToUser(recipient);
        kudoForm.selectCategory(category);
        kudoForm.writeMessage(message);
        kudoForm.submitBySlider();
    }
}