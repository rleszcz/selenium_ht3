import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends SimplePage {
    @FindBy(xpath = "//a[@role=\"button\" and contains(text(), \"Add to cart\")]")
    private static WebElement ADD_TO_CART_BUTTON;

    @FindBy(xpath = "//*[contains(text(), \"Go to cart\")]")
    private static WebElement GO_TO_CART_BUTTON;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Add to cart")
    public ItemPage addToCart() {
        clickOnElement(waitToBeClickable(ADD_TO_CART_BUTTON, driver));
        return this;
    }

    @Step("Go to cart")
    public ItemPage goToCart() {
        clickOnElement(waitToBeClickable(GO_TO_CART_BUTTON, driver));
        return this;
    }
}
