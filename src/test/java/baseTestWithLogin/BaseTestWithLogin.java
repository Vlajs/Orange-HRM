package baseTestWithLogin;

import baseTest.BaseTest;
import methods.LandingMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import property.PropertyManager;

public class BaseTestWithLogin extends BaseTest {
    @Override
    @Parameters({"browser", "url"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url){
        super.setUp(browser, url);
        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.successfullyLoginMethod(PropertyManager.getInstance().getUsername(),
                PropertyManager.getInstance().getPassword(), PropertyManager.getInstance().getSuccessfullyLoginUrl());
    }
}
