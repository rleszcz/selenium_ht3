package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends SimplePage {

    @FindBy(xpath = "(//ul[@class=\"srp-results srp-list clearfix\"]/li)[1]//h3")
    private static WebElement THE_FIRST_ITEM_LISTED;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    @Step("Click on the first item that was listed")
    public SearchResultsPage clickOnTheFirstItemListed() {
        clickOnElement(waitToBeClickable(THE_FIRST_ITEM_LISTED, driver));
        return this;
    }

}
