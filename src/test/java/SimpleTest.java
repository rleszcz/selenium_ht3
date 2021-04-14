import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SimpleTest {
    protected WebDriver driver;
    protected HomePage homePage = null;
    protected SearchResultsPage searchResultsPage = null;
    protected ItemPage itemPage = null;
    @BeforeMethod
    public void preparation() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-geolocation");
        co.addArguments("--incognito");
        co.addArguments("--start-maximized");
        driver = new ChromeDriver(co);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
