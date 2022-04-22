package stepdefinitions;

import contextManagers.TestContext;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUpBeforeEachTest() {
        testContext.getWebDriverManager().getDriverRun();
    }

    @After
    public void tearDownAfterEachTest() {
        testContext.getWebDriverManager().getDriverRun().close();
        testContext.getWebDriverManager().getDriverRun().quit();
    }
}
