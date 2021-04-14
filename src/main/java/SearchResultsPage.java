import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends SimplePage {

    @FindBy(xpath = "(//ul[@class=\"srp-results srp-list clearfix\"]/li)[1]//h3[@class=\"s-item__title\"]")
    private static WebElement THE_FIRST_ITEM_LISTED;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Click on the first item that was listed")
    public SearchResultsPage clickOnTheFirstItemListed() {
        clickOnElement(waitToBeClickable(THE_FIRST_ITEM_LISTED, driver));
        return this;
    }

}
