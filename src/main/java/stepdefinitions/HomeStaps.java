package stepdefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageobjects.HomePage;

public class HomeStaps {
    private TestContext context;
    private HomePage homePage;

    public HomeStaps(TestContext testContext) {
        context = testContext;
        homePage = new HomePage(context.getWebDriverManager().getDriverRun());
    }

    @When("^user clicks on my account button from navigation bar$")
    public void userClicksOnMyAccountButtonFromNavigationBar() {
        homePage.clickOnMyAccountButton();
    }

    @And("^Register button is clicked$")
    public void registerButtonIsClicked() {
        homePage.clickOnRegistrenButton();
    }

    @And("^user clicks on register button from navigation bar$")
    public void userClicksOnRegisterButtonFromNavigationBar() {
        homePage.navigateToRegisterPage();
    }
}
