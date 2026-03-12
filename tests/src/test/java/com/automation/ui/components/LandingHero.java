package com.automation.ui.components;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.interactions.Actions;

public class LandingHero extends PageComponent {
    @FindBy(xpath = "//span[contains(text(),'Desliza para conectar')]")
    private WebElementFacade heroText;
    @FindBy(xpath = "//span[contains(text(),'Desliza para conectar')]/ancestor::div[contains(@class,'rounded-full')]")
    private WebElementFacade slider;

    public void slideToComplete() {
        int width = slider.getSize().getWidth();
        Actions action = new Actions(getDriver());
        action.clickAndHold(slider)
              .moveByOffset(width, 0)
              .release()
              .build()
              .perform();
    }

    public boolean isHeroTextVisible() {
        return heroText.isVisible();
    }
}

