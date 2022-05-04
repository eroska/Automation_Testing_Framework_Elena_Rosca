package pageobjects;

import managers.PropertiesManager;
import managers.WebDriverWaiterManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Method;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    protected WebElement myAcountButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    protected WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    protected WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    protected WebElement searchButton;


    protected final String Base_URL = PropertiesManager.getBaseUrl();

    public void navigateToRegisterPage() {
        WebDriverWaiterManager.waitElimentToBeVisible(myAcountButton, driver);
        myAcountButton.click();
        WebDriverWaiterManager.waitElimentToBeVisible(registerButton, driver);
        WebDriverWaiterManager.waitElementToBeClickable(registerButton, driver);
        registerButton.click();
    }

    public void performSearchFor(String valoareCautata) {
        searchInputField.sendKeys(valoareCautata);
        searchButton.click();
    }

    public void clearSearchField() {
        searchInputField.clear();
    }

    public static void navigateToPage(String pageName, WebDriver driver) {
        Method defineMethod;
        try {
            defineMethod = Class.forName("pageobjects." + pageName).getMethod("goToPage");
            defineMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pageContainCorrectEndpoint(String pageName, WebDriver webDriver) {
        Method defineMethod;
        try {
            defineMethod = Class.forName("pageobjects" + pageName).getMethod("getENDPOINT");

            String valoareaEndpoint = (String) defineMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(webDriver));
            String valoareaActualaEndpoint = webDriver.getCurrentUrl();
            Assertions.assertTrue(valoareaActualaEndpoint.contains(valoareaEndpoint), "The ENDPOINT defined in the pageObject of " + pageName + "Page is not present within the curent URLaddress");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
