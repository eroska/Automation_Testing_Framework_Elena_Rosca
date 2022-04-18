import managers.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManagerObject = new WebDriverManager("Chrome");
        webDriverManagerObject.getDriverRun().get("https://demo.opencart.com/\n");

        HomePage homePage = new HomePage(webDriverManagerObject.getDriverRun());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObject.getDriverRun());
        registerPage.filliTheRegistrationPageForm("Margarita", "Popescu", "margpop@gmail.com", "0224565856", "4865555525", "4865555525");


        Thread.sleep(3000);

        webDriverManagerObject.getDriverRun().close();
        webDriverManagerObject.getDriverRun().quit();


    }
}


