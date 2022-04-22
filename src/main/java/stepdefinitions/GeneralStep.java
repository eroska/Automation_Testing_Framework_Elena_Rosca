package stepdefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GeneralStep {

    private TestContext context;

    public GeneralStep(TestContext testContext) {
        this.context = testContext;
    }


    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String addressUrl) {

        WebDriver driver = context.getWebDriverManager().getDriverRun();
        driver.get(addressUrl);
        String url = driver.getCurrentUrl();

        Assert.assertEquals(addressUrl, url);

    }

    @Then("^\"([^\"]*)\" is present within curent url$")
    public void isPresentWithinCurentUrl(String keyWord) {

        boolean urlIsValide = context.getWebDriverManager().getDriverRun().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(urlIsValide, "Address URL is not valid");

        Hooks hooks= new Hooks(context);
        hooks.tearDownAfterEachTest();
    }
}
