package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSettings {
    public WebDriver driver;
    public void firefoxDriver (){
        WebDriverManager.firefoxdriver().create();
        driver = new FirefoxDriver(new FirefoxOptions().addArguments("--width=1920", "--height=1080"));
    }
    public void chromeDriver (){
        String filePath = System.getenv("ChromeExeFilePath");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(filePath);
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    public void edgeDriver (){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(new EdgeOptions().addArguments("--start-maximized"));
    }
}
