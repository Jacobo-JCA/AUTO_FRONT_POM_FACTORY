package com.automation.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.StaleElementReferenceException;

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
            "Santiago", "santiago@sofkianos.com",
            "Frontend Team", "frontend@sofkianos.com",
            "Backend Team", "backend@sofkianos.com"
    );

    public boolean isReady() {
        pageHeader.waitUntilVisible();
        return pageHeader.isVisible();
    }

    public boolean hasKudoWith(String from, String recipient, String category, String message) {
        String fromEmail = USER_EMAILS.getOrDefault(from, from);
        String recipientEmail = USER_EMAILS.getOrDefault(recipient, recipient);
        pageHeader.waitUntilVisible();
        return kudoRows.stream()
                .map(row -> {
                    try {
                        return row.getText();
                    } catch (StaleElementReferenceException e) {
                        return "";
                    }
                })
                .anyMatch(text ->
                        text.contains(fromEmail)
                                && text.contains(recipientEmail)
                                && text.contains(category.toUpperCase())
                                && text.contains(message)
                );
    }
}
