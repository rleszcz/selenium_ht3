import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public abstract class SimpleTest {
    protected WebDriver driver;
    protected HomePage homePage = null;
    protected SearchResultsPage searchResultsPage = null;
    protected ItemPage itemPage = null;
    protected DriverManager driverManager = null;

    @Parameters("browserName")

    @BeforeMethod
    public void preparation(String browserName, ITestContext context){
        driverManager = new DriverManager();
        driver = driverManager.getDriver(browserName);
        context.setAttribute("WebDriver", driver);

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
