package tests;

import baseTest.BaseTest;
import methods.LandingMethod;
import org.testng.annotations.Test;

public class ResetPasswordTest extends BaseTest {
    @Test
    public void successfullyResetPasswordTest(){
        String resetPasswordUsername = "Admin";
        String resetPasswordUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
        String resetPasswordText = "Reset Password link sent successfully";
        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.resetPasswordSuccessfullyMethod(resetPasswordUsername, resetPasswordText, resetPasswordUrl);
    }
    @Test
    public void unsuccessfullyResetPasswordTest(){
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.resetPasswordUnsuccessfullyMethod(url);
    }
}
