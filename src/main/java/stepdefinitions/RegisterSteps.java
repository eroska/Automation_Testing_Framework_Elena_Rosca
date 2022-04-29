package stepdefinitions;

import contextManagers.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobjects.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterSteps {
    private RegisterPage registerPage;
    private TestContext context;

    public RegisterSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriverRun());
    }

    @When("^The register fields are populated with the following data:$")
    public void theRegisterFieldsArePopulatedWithTheFollowingData(Map<String, String> collectedRegisterDataMap) {
        String colectedFirstName = collectedRegisterDataMap.get("firstName");
        String colectedLastName = collectedRegisterDataMap.get("lastName");
        String colectedEmail = collectedRegisterDataMap.get("email");
        String colectedPhoneNumber = collectedRegisterDataMap.get("phoneNumber");
        String colectedPassword = collectedRegisterDataMap.get("password");
        String colectedConfirmPassword = collectedRegisterDataMap.get("confirmPassword");

        registerPage.filliTheRegistrationPageForm(colectedFirstName, colectedLastName, colectedEmail, colectedPhoneNumber, colectedPassword, colectedConfirmPassword);
    }

    @And("^privacyCheckBox is clicked$")
    public void privacycheckboxIsClicked() {
        registerPage.clickCheckBox();
    }

    @And("^Continue button is clicked$")
    public void continueButtonIsClicked() {
        registerPage.clickContinueButton();
    }

    @Then("^the following key words are present within an error message$")
    public void theFollowingKeyWordsArePresentWithinAnErrorMessage(List<String> keyWordsList) {
        String displayErrorMessage = registerPage.getTheErrorMessageText();
        for (int i = 0; i < keyWordsList.size(); i++) {
            boolean keyWordIsPresentWithinTheDisplayedMessage = displayErrorMessage.contains(keyWordsList.get(i));
            Assertions.assertTrue(keyWordIsPresentWithinTheDisplayedMessage, "The keyword was not present within the error message");
        }

        Hooks hooks = new Hooks(context);
        hooks.tearDownAfterEachTest();
    }
}
