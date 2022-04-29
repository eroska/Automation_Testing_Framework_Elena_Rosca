package stepdefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobjects.Page;

public class GeneralStep {

    private TestContext context;

    public GeneralStep(TestContext testContext) {
        this.context = testContext;
    }

    @Then("^\"([^\"]*)\" is present within current url$")
    public void isPresentWithinCurentUrl(String pageName) {

        boolean pageContainCorrectEndpoint = context.getWebDriverManager().getDriverRun().getCurrentUrl().contains(pageName);
        Assertions.assertTrue(pageContainCorrectEndpoint, "The actual Url dose not contain the correct endpoint");

        Hooks hooks = new Hooks(context);
        hooks.tearDownAfterEachTest();
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String pageName) {
        Page.navigateToPage(pageName, context.getWebDriverManager().getDriverRun());
        context.getWebDriverManager().getDriverRun().manage().window().maximize();

    }

    @Then("^Correct \"([^\"]*)\" endpoint is displayed$")
    public void correctEndpointIsDisplayed(String pageName) {
        Page.pageContainCorrectEndpoint(pageName, context.getWebDriverManager().getDriverRun());


    }
}
