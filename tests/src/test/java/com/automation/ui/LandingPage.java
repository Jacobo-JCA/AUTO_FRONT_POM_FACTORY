package com.automation.ui;

import com.automation.ui.components.LandingHero;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("http://localhost:5173/")
public class LandingPage extends PageObject {
    private LandingHero landingHero;

    public void launchApp() {
        landingHero.slideToComplete();
    }

    public boolean isReady() {
        return landingHero.isHeroTextVisible();
    }
}
