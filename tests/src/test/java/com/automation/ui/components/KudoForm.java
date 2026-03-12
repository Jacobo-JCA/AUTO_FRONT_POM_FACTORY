package com.automation.ui.components;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.interactions.Actions;

public class KudoForm extends PageComponent {
    @FindBy(xpath = "//span[contains(text(),'Desliza para enviar')]")
    private WebElementFacade submitSliderText;
    @FindBy(xpath = "//span[contains(text(),'Desliza para enviar')]/ancestor::div[contains(@class,'rounded-full')]")
    private WebElementFacade submitSlider;

    public boolean isFormVisible() {
        return submitSliderText.isVisible();
    }

    public void submitForm() {
        int width = submitSlider.getSize().getWidth();
        Actions action = new Actions(getDriver());
        action.clickAndHold(submitSlider)
                .moveByOffset(width, 0)
                .release()
                .perform();
    }
}