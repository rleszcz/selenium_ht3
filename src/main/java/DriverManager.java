import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class DriverManager {

    public WebDriver getDriver(String driverType){

        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase(Locale.ROOT)) {
            case "CHROME" -> {
                requestedDriver = initChrome();
            }
            case "FIREFOX" -> {
                requestedDriver = initFirefox();
            }
            case "EDGE" -> {
                requestedDriver = initEdge();
            }
        }
        return requestedDriver;
    }

    private WebDriver initChrome(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path") + "/chromedriver.exe");
        return new ChromeDriver();
    }
    private WebDriver initFirefox(){
        //firefox requires not only browser to be installed but also profile to be created.
        System.setProperty("webdriver.gecko.driver", System.getProperty("driver.path") + "/geckodriver.exe");
        FirefoxProfile profile = new ProfilesIni().getProfile("default");
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setProfile(profile);
        return new FirefoxDriver(ffOptions);
    }

    private WebDriver initEdge(){
        System.setProperty("webdriver.edge.driver", System.getProperty("driver.path") + "/msedgedriver.exe");
        return new EdgeDriver();
    }
}
