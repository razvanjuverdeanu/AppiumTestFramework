package pages;

import component.TheDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static helpers.Constants.denyPushMsg;

@Component
public class BasePage {

    @Autowired
    TheDriver driver;

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public WebElement findElement(By locator) {
        return driver.getDriver().findElement(locator);
    }

    public void sendKeysToElement(By locator, String text) {
        waitForElement(locator);
        driver.getDriver().findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        try {
            return driver.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException n) {
            return false;
        }
    }

    public void hideTheKeyboard(){
        driver.getDriver().hideKeyboard();
    }


}
