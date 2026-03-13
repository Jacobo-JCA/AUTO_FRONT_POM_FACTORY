package com.automation.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

@DefaultUrl("http://localhost:5173/kudos/list")
public class KudoListPage extends PageObject {
    @FindBy(xpath = "//h1[contains(text(),'Explorar')]")
    private WebElementFacade pageHeader;
    @FindBy(xpath = "//table//tbody//tr")
    private List<WebElementFacade> kudoRows;

    private static final Map<String, String> USER_EMAILS = Map.of(
            "Christopher Pallo", "christopher@sofkianos.com",
            "Santiago",          "santiago@sofkianos.com",
            "Frontend Team",     "frontend@sofkianos.com",
            "Backend Team",      "backend@sofkianos.com"
    );

    public boolean isReady() {
        pageHeader.waitUntilVisible();
        return pageHeader.isVisible();
    }

    public boolean hasKudoWith(String from, String recipient, String category, String message) {
        String fromEmail      = USER_EMAILS.getOrDefault(from, from);
        String recipientEmail = USER_EMAILS.getOrDefault(recipient, recipient);
        String categoryUpper  = category.toUpperCase();

        pageHeader.waitUntilVisible();

        for (WebElementFacade row : kudoRows) {
            try {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (cells.size() < 4) continue;

                String cellFrom      = cells.get(0).getText().trim();
                String cellRecipient = cells.get(1).getText().trim();
                String cellCategory  = cells.get(2).getText().trim().toUpperCase();
                String cellMessage   = cells.get(3).getText().trim();

                if (cellFrom.equals(fromEmail)
                        && cellRecipient.equals(recipientEmail)
                        && cellCategory.equals(categoryUpper)
                        && cellMessage.equals(message)) {
                    return true;
                }
            } catch (StaleElementReferenceException e) {

            }
        }
        return false;
    }
}