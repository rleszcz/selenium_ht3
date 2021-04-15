package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineShopTest extends SimpleTest{

    static final String SEARCH_PHRASE = "Lego 42100";
    static final String CART_CONTENT_XPATH = "//div[@class=\"cart-bucket-lineitem\"]";
    static final String POLISH_LOGO_BUTTON_XPATH = "//header[@id=\"gh\"]//a[@href=\"https://www.ebay.pl\"]";

    static final String MY_EBAY_SECTION_ITEM_SUMMARY_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Summary\")]";
    static final String MY_EBAY_SECTION_ITEM_RECENTLY_VIEWED_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Recently Viewed\")]";
    static final String MY_EBAY_SECTION_ITEM_BIDS_OFFERS_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Bids/Offers\")]";
    static final String MY_EBAY_SECTION_ITEM_WATCHLIST_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Watchlist\")]";
    static final String MY_EBAY_SECTION_ITEM_PURCHASE_HISTORY_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Purchase History\")]";
    static final String MY_EBAY_SECTION_ITEM_BUY_AGAIN_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Buy Again\")]";
    static final String MY_EBAY_SECTION_ITEM_SELLING_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Selling\")]";
    static final String MY_EBAY_SECTION_ITEM_SAVED_SEARCHES_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Searches\")]";
    static final String MY_EBAY_SECTION_ITEM_SAVED_SELLERS_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Sellers\")]";
    static final String MY_EBAY_SECTION_ITEM_MESSAGES_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Messages\")]";

    @Test
    public void searchForLegoAndAddToCart() {
        homePage.open()
                .searchFor(SEARCH_PHRASE);
        searchResultsPage.clickOnTheFirstItemListed();
        itemPage.addToCart()
                .goToCart();
        waitPresent(CART_CONTENT_XPATH, 5);
        Assert.assertTrue(driver.get().findElement(By.xpath(CART_CONTENT_XPATH)).isDisplayed());
    }

    @Test
    public void switchSiteToPoland() {
        homePage.open()
                .navigateToPolishVersion();
        waitPresent(POLISH_LOGO_BUTTON_XPATH, 5);
        Assert.assertTrue(driver.get().findElement(By.xpath(POLISH_LOGO_BUTTON_XPATH)).isDisplayed());
    }

    @Test
    public void checkIfThereAreNoMissingItemsOfMyEbaySection() {
        homePage.open()
                .openMyEbaySection();
        waitClickable(MY_EBAY_SECTION_ITEM_SUMMARY_XPATH, 5);
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_SUMMARY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_RECENTLY_VIEWED_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_BIDS_OFFERS_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_WATCHLIST_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_PURCHASE_HISTORY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_BUY_AGAIN_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_SELLING_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_SAVED_SEARCHES_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_SAVED_SELLERS_XPATH)).isDisplayed());
        Assert.assertTrue(driver.get().findElement(By.xpath(MY_EBAY_SECTION_ITEM_MESSAGES_XPATH)).isDisplayed());
    }
}
