import config.ApplicationContextConfig;
import component.TheDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.HomePage;
import pages.SearchPage;

@ContextConfiguration(classes = ApplicationContextConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TheDriver driver;
    @Autowired
    BasePage page;
    @Autowired
    HomePage homePage;
    @Autowired
    SearchPage searchPage;

    public String rakutenLink = "https://www.rakuten.com";

    @BeforeMethod(alwaysRun = true)
    public void createTestContext(ITestContext context) {
        context.setAttribute("driver", driver.getDriver());
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver.get(rakutenLink);
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.closeDriver();
    }



}
