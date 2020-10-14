package component;

import config.ApplicationContextConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component
public class TheDriver extends ApplicationContextConfig {

    public  static AppiumDriver driver;

    public TheDriver() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "8.0.0");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("chromedriverExecutable", "C:\\Users\\RJ\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
        dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability("noReset", "true");
        dc.setCapability("newCommandTimeout", 600);
        dc.setCapability("nativeWebScreenshot",true);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public void closeDriver() {
        driver.quit();
    }

}
