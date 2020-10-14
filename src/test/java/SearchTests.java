import helpers.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static helpers.Constants.priceFilter;
import static org.testng.Assert.*;


@Listeners(TestListener.class)
public class SearchTests extends BaseTest {

    String searchedItem = "xbox";

    @Test
    public void checkPriceFilter() {
        homePage.acceptCookie();
        homePage.clickSearchIcon();
        homePage.typeInSearchBar(searchedItem);
        homePage.pressSearchButton();

        homePage.denyNewsletterMsg();
        searchPage.clickFilterButton();
        searchPage.selectFIlterTypeValueByIndex(priceFilter, 1);

        List<Double> priceList = searchPage.getAllSearchedProductsPrice();
        assertTrue( searchPage.getMaxValueOfPriceInterval() > priceList.get(priceList.size()-1));
        assertTrue( searchPage.getMinValueOfPriceInterval() < priceList.get(0));
    }

}
