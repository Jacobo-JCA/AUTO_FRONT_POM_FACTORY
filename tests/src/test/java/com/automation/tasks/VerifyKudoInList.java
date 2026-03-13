package com.automation.tasks;

import com.automation.page.KudoListPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerifyKudoInList {
    KudoListPage kudosListPage;

    @Step("Navegar a la página de lista de Kudos")
    public void navigateToList() {
        kudosListPage.open();
        assertThat(kudosListPage.isReady())
                .as("La página de lista de Kudos debería estar visible")
                .isTrue();
    }

    @Step("Verificar que existe un Kudo de {0} para {1} con categoría {2} y mensaje '{3}'")
    public void verifyKudoExists(String from, String recipient, String category, String message) {
        assertThat(kudosListPage.hasKudoWith(from, recipient, category, message))
                .as("Debería existir un Kudo de '%s' para '%s' con categoría '%s' y mensaje '%s'"
                        .formatted(from, recipient, category, message))
                .isTrue();
    }
}