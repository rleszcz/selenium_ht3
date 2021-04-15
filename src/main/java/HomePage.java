import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SimplePage {

    private static final String HOME_PAGE_URL = "https://www.ebay.com/";

    @FindBy(xpath = "//input[@type=\"text\"]")
    private static WebElement SEARCH_FIELD;

    @FindBy(xpath = "//a[@role=\"button\" and @class=\"thrd\"]")
    private static WebElement SITE_SELECTION_TAB;

    @FindBy(xpath = "//p[contains(text(), \"Poland\")]")
    private static WebElement POLAND_BUTTON;

    @FindBy(xpath = "//a[@title=\"My eBay\"]")
    private static WebElement MY_EBAY_SECTION_BUTTON;

    @FindBy(xpath = "//button[@id=\"gdpr-banner-accept\"]")
    private static WebElement GDPR_ACCEPT_BUTTON;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open home page")
    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        return this;
    }

    @Step("Search for...")
    public HomePage searchFor(String searchPhrase) {
        enterTextIntoField(SEARCH_FIELD, searchPhrase);
        pressKey(Keys.ENTER);
        return this;
    }

    @Step("Navigate to Polish version")
    public HomePage navigateToPolishVersion() {
        scrollTo(driver, SITE_SELECTION_TAB);
        clickOnElement(waitToBeClickable(GDPR_ACCEPT_BUTTON, driver));
        mouseOverElement(SITE_SELECTION_TAB);
        clickOnElement(waitToBeClickable(POLAND_BUTTON, driver));
        return this;
    }

    @Step("Open My eBay section")
    public HomePage openMyEbaySection() {
        mouseOverElement(MY_EBAY_SECTION_BUTTON);
        return this;
    }

}
