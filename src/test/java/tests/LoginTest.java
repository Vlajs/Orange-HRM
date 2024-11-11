package tests;

import baseTest.BaseTest;
import methods.LandingMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 3)
    public void successfullyLoginTest(){
        String username = "Admin";
        String password = "admin123";
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.successfullyLoginMethod(username, password, url);
    }
    @Test(priority = 2)
    public void unsuccessfullyLoginTest(){
        String username = "123";
        String password = "456";
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String errorMessage = "Invalid credentials";

        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.unsuccessfullyLoginMethod(username, password, url, errorMessage);
    }
    @Test(priority = 1)
    public void emptyLoginTest(){
        String username = "";
        String password = "";
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String usernameErrorMessage = "Required";
        String passwordErrorMessage = "Required";

        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.emptyLoginMethod(username, password, url, usernameErrorMessage, passwordErrorMessage);
    }
}
