import managers.WebDriverManager;

public class TestRunner {
    public static void main(String[] args) {

        WebDriverManager webDriverManagerObject = new WebDriverManager("Chrome");
        webDriverManagerObject.getDriverRun().get("https://www.endava.com/");
        webDriverManagerObject.getDriverRun().close();
        webDriverManagerObject.getDriverRun().quit();


        WebDriverManager webDriverManagerFireFox = new WebDriverManager("Firefox");
        webDriverManagerFireFox.getDriverRun().get("https://www.amdaris.com/");
        webDriverManagerFireFox.getDriverRun().close();

        webDriverManagerObject.getDriverRun().quit();


    }


}
