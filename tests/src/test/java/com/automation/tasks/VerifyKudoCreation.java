package com.automation.tasks;

import com.automation.page.components.KudoForm;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyKudoCreation {

    KudoForm kudoForm; // package-private: Serenity inyecta PageComponents automáticamente en @Steps

    @Step("Verificar que el toast de éxito 'Kudo enviado' es visible")
    public void isSuccessful() {
        assertThat(kudoForm.isSuccessToastVisible())
                .as("El toast de éxito 'Kudo enviado' debería estar visible tras enviar el formulario")
                .isTrue();
    }
}