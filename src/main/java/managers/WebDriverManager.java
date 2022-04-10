package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverManager {
    public WebDriverManager(String browserType) {
        this.browserType = browserType;
    }


    public void setDriverRun(WebDriver driverRun) {
        this.driverRun = driverRun;
    }

    private WebDriver driverRun;
    private final String browserType;

    private void initializeDriver() {
        if (browserType.toUpperCase(Locale.ROOT).equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drives/chromedriver.exe");
            driverRun = new ChromeDriver();
        } else if (browserType.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drives/geckodriver.exe");
            driverRun = new FirefoxDriver();
        } else {
            System.out.println("This type of Driver does not implemented");
        }
    }

    public WebDriver getDriverRun() {
        if (driverRun == null) {

            System.out.println("Initializarea browserului dorit");
            initializeDriver();
        }
        return driverRun;
    }


}
