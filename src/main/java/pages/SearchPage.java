package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helpers.Constants.*;

@Component
public class SearchPage {

    @Autowired
    BasePage page;

    public List<Double> getAllSearchedProductsPrice() {
        List<Double> priceList = new ArrayList<Double>();
        int total = getReturnedResultsNumber();
        for (int i = 1; i <= total; i++) {
            try {
                priceList.add(extractNumberFromPrice(i));
            } catch (NoSuchElementException e) {
                continue;
            }
        }
        Collections.sort(priceList);
        return priceList;
    }

    @Step
    public double extractNumberFromPrice(int index) {
        String priceString = page.driver.getDriver().findElement(By.cssSelector(String.format(productPrice, index))).getText();
        int s = priceString.indexOf("€");
        return Double.parseDouble(priceString.substring(0, s).replace(",", ".").trim());
    }

    public double getMinValueOfPriceInterval() {
        String priceString = page.driver.getDriver().findElement(filterCard).getText();
        int x = priceString.indexOf(":") + 1;
        int y = priceString.indexOf("-");
        return Double.parseDouble(priceString.substring(x, y).replace(",", ".").trim());
    }

    public double getMaxValueOfPriceInterval() {
        String priceString = page.driver.getDriver().findElement(filterCard).getText();
        int x = priceString.indexOf("-") + 1;
        int y = priceString.indexOf("€");
        return Double.parseDouble(priceString.substring(x, y).replace(",", ".").trim());
    }

    public int getReturnedResultsNumber() {
        return Integer.parseInt(page.driver.getDriver().findElement(resultsNumber).getText().replaceAll("[()]", ""));
    }

    public void denyNewsletterMsg() {
        page.waitForElement(denyPushMsg);
        page.clickElement(denyPushMsg);
    }

    public void clickFilterButton() {
        page.clickElement(filterButton);
    }


    public void selectFIlterTypeValueByIndex(By filterType, int index) {
        Select price = new Select(page.findElement(filterType));
        price.selectByIndex(index);
    }
}
