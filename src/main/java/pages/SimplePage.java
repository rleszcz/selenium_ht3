package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SimplePage extends Page {
    protected WebDriver driver;

    public SimplePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void clickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    protected void mouseOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void enterTextIntoField(WebElement element, String text) {
        Actions actions = new Actions(driver);
        actions.sendKeys(element, text).perform();
    }

    protected void openWebPage(String url) {
        driver.navigate().to(url);
    }

    protected void pressKey(Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    protected WebElement waitToBeClickable(WebElement element, WebDriver driver) {
        WebElement visibleElement = null;
        try {
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element was not loaded!");
        }
        return visibleElement;
    }

    protected void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

}
