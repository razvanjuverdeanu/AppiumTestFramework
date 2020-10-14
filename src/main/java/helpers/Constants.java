package helpers;

import org.openqa.selenium.By;

public class Constants {
    //Search Page By elements
    public static String productPrice = "li:nth-child(%d) > a > div.price";
    public static By filterButton = By.cssSelector("section.vw-searchMenu > div");
    public static By denyPushMsg = By.cssSelector("#onesignal-slidedown-cancel-button");
    public static By priceFilter = By.cssSelector("div.select-range > select");
    public static By resultsNumber = By.cssSelector("h1 > span.results");
    public static By loginIcon = By.cssSelector("a.icon-button.-user");

    //Home Page By elements
    public static By consent = By.cssSelector("#consent_prompt_submit");
    public static By searchIcon = By.cssSelector("div > a.icon-button.-search > div > svg");
    public static By searchButton = By.cssSelector("#search > button");
    public static By searchInput = By.cssSelector("#search-input");
    public static By filterCard = By.cssSelector("div.filterCard > span");

    //Login Page By elements
    public static By loginBox = By.cssSelector("div > input[name=loginEmail]");
    public static By passwordBox = By.cssSelector("div > input[name=loginPassword]");
    public static By submitLogin = By.cssSelector("#recaptcha-submit");

}
