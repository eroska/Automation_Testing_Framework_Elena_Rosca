import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManagerObject = new WebDriverManager("Chrome");
        webDriverManagerObject.getDriverRun().get("https://demo.opencart.com/\n");

        WebElement myAccountButton = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));

        myAccountButton.click();
        WebElement registrationButton = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registrationButton.click();
        WebElement firstNameInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        WebElement lastNameInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        WebElement emailAddressInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-email\"]"));
        WebElement telephoneInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-telephone\"]"));
        WebElement passwordInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-password\"]"));
        WebElement confirmPassworgInput = webDriverManagerObject.getDriverRun().findElement(By.xpath("//*[@id=\"input-confirm\"]"));

        firstNameInput.sendKeys("Helena");
        lastNameInput.sendKeys("Rossa");
        emailAddressInput.sendKeys("email@gma.com");
        telephoneInput.sendKeys("068975159");
        passwordInput.sendKeys("1365#4789");
        confirmPassworgInput.sendKeys("1365#4789");
        Thread.sleep(3000);

        webDriverManagerObject.getDriverRun().close();
        webDriverManagerObject.getDriverRun().quit();


    }


}
