package com.automation.page;

import com.automation.page.components.KudoForm;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class KudosPage extends PageObject {
    private KudoForm kudoForm;
    @FindBy(xpath = "//h2[contains(.,'Reconoce a un')]")
    private WebElementFacade pageTitle;

    public String getTitle() {
        return pageTitle.getText();
    }

    public boolean isKudoFormVisible() {
        return kudoForm.isFormVisible();
    }
}
