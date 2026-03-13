package com.automation.tasks;

import com.automation.page.components.KudoForm;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyKudoCreation {
    private KudoForm kudoForm;
    
    @Step("Verify that the success Kudo created toast is displayed")
    public void isSuccessful() {
        assertThat(kudoForm.isSuccessToastVisible())
                .as("El Toast de éxito 'Kudo created' debería estar visible después de enviar el formulario")
                .isTrue();
    }
}
