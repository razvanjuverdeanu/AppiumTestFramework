package pages;

import helpers.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static helpers.Constants.*;

@Component
public class HomePage {

    @Autowired
    BasePage page;

    public void acceptCookie() {
        page.waitForElement(Constants.consent);
        page.clickElement(consent);
    }

    public void clickSearchIcon() {
        page.clickElement(searchIcon);
    }

    public void clickUserAccountIcon() {
        page.clickElement(loginIcon);
    }

    public void typeInSearchBar(String text) {
        page.sendKeysToElement(searchInput, text);
    }

    public void pressSearchButton() {
        page.clickElement(searchButton);
    }

    public void denyNewsletterMsg() {
        page.waitForElement(denyPushMsg);
        page.clickElement(denyPushMsg);
    }


}
