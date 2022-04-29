package stepdefinitions;

import contextManagers.TestContext;
import pageobjects.RegisterPage;

public class RegistrationSteps {

    private TestContext context;
    private RegisterPage registerPage;

    public RegistrationSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriverRun());
    }


}
