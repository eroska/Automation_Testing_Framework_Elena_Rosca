package contextManagers;

import managers.PropertiesManager;
import managers.WebDriverManager;

public class TestContext {

    private WebDriverManager webDriverManager;
    private String browserType = PropertiesManager.getbrowserType();

    public TestContext() {
        webDriverManager = new WebDriverManager(browserType);
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
}
