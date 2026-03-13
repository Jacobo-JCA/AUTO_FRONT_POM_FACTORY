package com.automation.page.components;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KudoForm extends PageComponent {
    @FindBy(name = "from")
    private WebElementFacade fromUserSelect;
    @FindBy(name = "to")
    private WebElementFacade toUserSelect;
    @FindBy(name = "category")
    private WebElementFacade categorySelect;
    @FindBy(name = "message")
    private WebElementFacade messageField;
    @FindBy(xpath = "//div[contains(@class,'rounded-full') and contains(@class,'cursor-pointer')]")
    private WebElementFacade sliderContainer;
    @FindBy(xpath = "//div[contains(@class,'rounded-full') and contains(@class,'cursor-pointer')]//div[contains(@class,'bg-brand')]")
    private WebElementFacade sliderButton;
    @FindBy(xpath = "//span[contains(@class,'tracking') and contains(text(),'Desliza para enviar')]")
    private WebElementFacade submitSliderText;
    @FindBy(xpath = "//li[@data-sonner-toast]//*[contains(text(),'Kudo enviado')]")
    private WebElementFacade successToast;

    private void waitForToastToDisappear() {
        try {
            successToast.waitUntilNotVisible();
        } catch (Exception ignored) {
            Serenity.recordReportData()
                    .withTitle("Toast check")
                    .andContents("No active toast found before form load — continuing normally");
        }
    }

    public boolean isFormVisible() {
        waitForToastToDisappear();
        submitSliderText.waitUntilVisible();
        return submitSliderText.isVisible();
    }

    public void selectFromUser(String user) {
        fromUserSelect.waitUntilVisible();
        fromUserSelect.selectByVisibleText(user);
    }

    public void selectToUser(String recipient) {
        toUserSelect.waitUntilVisible();
        waitForSelectToHaveOptions(toUserSelect);
        toUserSelect.selectByVisibleText(recipient);
    }

    public void selectCategory(String category) {
        categorySelect.waitUntilVisible();
        waitForSelectToHaveOptions(categorySelect);
        categorySelect.selectByVisibleText(category);
    }

    private void waitForSelectToHaveOptions(WebElementFacade select) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(driver -> new Select(select).getOptions().size() > 1);
    }

    public void writeMessage(String message) {
        messageField.waitUntilVisible();
        messageField.type(message);
    }

    public void submitBySlider() {
        sliderContainer.waitUntilVisible();
        int width = sliderContainer.getSize().getWidth();
        new Actions(getDriver())
                .clickAndHold(sliderButton)
                .moveByOffset(width, 0)
                .release()
                .perform();
    }

    public boolean isSuccessToastVisible() {
        successToast.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        return successToast.getText().contains("Kudo enviado");
    }
}