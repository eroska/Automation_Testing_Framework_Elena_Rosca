package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"input-firstname\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"input-lastname\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"input-telephone\"]")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement confirmPassworgInput;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement privacyCheckBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class=\"text-danger\"]")
    private WebElement errorMessage;

    public void filliTheRegistrationPageForm(String firstName, String lastName, String email, String phone, String password, String confirmPassworg) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmPassworgInput.sendKeys(confirmPassworg);


    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickCheckBox() {
        privacyCheckBox.click();
    }

    public String getTheErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean allTheElementsAreDisplayed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() && phoneInput.isDisplayed() && passwordInput.isDisplayed() &&
                confirmPassworgInput.isDisplayed();
    }

}

