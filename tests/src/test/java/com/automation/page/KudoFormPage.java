package com.automation.page;

import com.automation.page.components.KudoForm;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("http://localhost:5173/kudos")
public class KudoFormPage extends PageObject {
    private KudoForm kudoForm;

    public boolean isReady() {
        return kudoForm.isFormVisible();
    }
}
