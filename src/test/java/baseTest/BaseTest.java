package baseTest;

import browsers.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends BrowserSettings {
    public String url;
    @BeforeMethod
    @Parameters ({"browsers", "url"})
    public void setUp(@Optional ("chrome") String browser, @Optional ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url){
        this.url = url;
        switch (browser.toLowerCase()){
            case "firefox":
                firefoxDriver();
                break;
            case "chrome":
                chromeDriver();
                break;
            case "edge":
                edgeDriver();
                break;
            default:
                firefoxDriver();
                System.out.println("Sorry, this browser is not supported. Firefox is opening.");
        }
        driver.get(this.url);
    }
    @AfterMethod
    public void tearDown (){
        if (driver != null){
            driver.quit();
        }
    }
    public WebDriver restartDriver (@Optional ("chrome") String browser, @Optional ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url){
        if (driver != null){
            driver.quit();
        }
        switch (browser.toLowerCase()){
            case "firefox":
                firefoxDriver();
                break;
            case "chrome":
                chromeDriver();
                break;
            case "edge":
                edgeDriver();
                break;
            default:
                firefoxDriver();
                System.out.println("Sorry, this browser is not supported. Firefox is opening.");
        }
        driver.get(url);
        return this.driver;
    }
    public WebDriver getDriver(){
        return this.driver;
    }
}
