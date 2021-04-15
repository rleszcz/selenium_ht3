package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    public WebDriver getDriver(String driverType){
        return getDriver(driverType, "LOCAL");
    }

    public WebDriver getDriver(String driverType, String gridMode){

        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase(Locale.ROOT)) {
            case "CHROME" -> {
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                        getRemoteDriver(CapabilityManager.getChromeOptions()) : getLocalChrome();
            }
            case "FIREFOX" -> {
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                        getRemoteDriver(CapabilityManager.getFirefoxOptions()) : getLocalFirefox();
            }
            case "EDGE" -> {
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                        getRemoteDriver(CapabilityManager.getEdgeOptions()) : getLocalEdge();
            }
        }
        return requestedDriver;
    }

    private WebDriver getLocalChrome(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path") + "/chromedriver.exe");
        return new ChromeDriver(CapabilityManager.getChromeOptions());
    }
    private WebDriver getLocalFirefox(){
        //firefox requires not only browser to be installed but also profile to be created.
        System.setProperty("webdriver.gecko.driver", System.getProperty("driver.path") + "/geckodriver.exe");
        return new FirefoxDriver(CapabilityManager.getFirefoxOptions());
    }

    private WebDriver getLocalEdge(){
        System.setProperty("webdriver.edge.driver", System.getProperty("driver.path") + "/msedgedriver.exe");
        return new EdgeDriver(CapabilityManager.getEdgeOptions());
    }

    private WebDriver getRemoteDriver(Capabilities capabilities){
        WebDriver requestedDriver = null;
        try{
            requestedDriver = new RemoteWebDriver(new URL(System.getProperty("selenium.grid.url")), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Remote driver creation failed");
        }
        return requestedDriver;
    }
}
