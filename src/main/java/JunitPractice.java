import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

import static java.lang.Thread.sleep;

public class JunitPractice {

    WebDriverManager webDriverManagerObject = new WebDriverManager("Chrome");

    @BeforeEach
    public void beforeTestProcedure() {
        webDriverManagerObject.getDriverRun().get("https://demo-opencart.com/\n");
    }

    @AfterEach
    public void afterTestInstructions() {
        webDriverManagerObject.getDriverRun().close();
        webDriverManagerObject.getDriverRun().quit();
    }


    @Test
    @DisplayName("The URL addres is displayed from Home")
    public void verifyTheRegistrationPageIAccessible() throws InterruptedException {


        HomePage homePage = new HomePage(webDriverManagerObject.getDriverRun());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObject.getDriverRun());
        registerPage.filliTheRegistrationPageForm("Margarita", "Popescu", "margpop@gmail.com", "0224565856", "4865555525", "4865555525");

        sleep(3000);
        boolean urlIsValide = webDriverManagerObject.getDriverRun().getCurrentUrl().contains("register");
        Assertions.assertTrue(urlIsValide, "Address URL is not valid");

    }

    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementeAreDisplayed() throws InterruptedException {


        HomePage homePage = new HomePage(webDriverManagerObject.getDriverRun());
        homePage.navigateToRegisterPage();

        sleep(3000);
        RegisterPage registerPage = new RegisterPage(webDriverManagerObject.getDriverRun());
        Assertions.assertTrue(registerPage.allTheElementsAreDisplayed(), "Cel putin unul dintre elemente nu a fost afisat");

    }

}
