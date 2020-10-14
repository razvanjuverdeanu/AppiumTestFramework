package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Utils {
    public void scrollDown(AppiumDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
    }
}
