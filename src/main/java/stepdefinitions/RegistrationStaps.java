package stepdefinitions;

import contextManagers.TestContext;
import pageobjects.RegisterPage;

public class RegistrationStaps {

    private TestContext context;
    private RegisterPage registerPage;

    public RegistrationStaps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriverRun());
    }


}
