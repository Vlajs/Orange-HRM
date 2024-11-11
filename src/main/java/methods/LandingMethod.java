package methods;

import org.openqa.selenium.WebDriver;
import pages.LandingPage;

public class LandingMethod extends LandingPage {
    public LandingMethod(WebDriver driver) {
        super(driver);
    }

    public void successfullyLoginMethod(String usernameText, String passwordText, String url){
        typeInUsernameField(usernameText);
        typeInPasswordField(passwordText);
        clickOnLoginButton();
        assertPage(url);
    }
    public void unsuccessfullyLoginMethod(String usernameText, String passwordText, String url, String errorText){
        typeInUsernameField(usernameText);
        typeInPasswordField(passwordText);
        clickOnLoginButton();
        assertPage(url);
        assertWrongData(errorText);
    }
    public void emptyLoginMethod(String usernameText, String passwordText, String url, String usernameErrorMessage, String passwordErrorMessage){
        typeInUsernameField(usernameText);
        typeInPasswordField(passwordText);
        clickOnLoginButton();
        assertPage(url);
        assertEmptyUsernameField(usernameErrorMessage);
        assertEmptyPasswordField(passwordErrorMessage);
    }
    public void resetPasswordSuccessfullyMethod(String usernameResetPasswordText, String resetPasswordText, String url){
        clickOnForgotPasswordLink();
        typeTextInUsernameResetPasswordField(usernameResetPasswordText);
        clickOnResetPasswordButton();
        assertResetPasswordText(resetPasswordText);
        assertPage(url);
    }
    public void resetPasswordUnsuccessfullyMethod(String url){
        clickOnForgotPasswordLink();
        clickOnCancelResetPasswordButton();
        assertPage(url);
    }
    public void checkingLinks(String orangeUrl, String linkedinUrl, String facebookUrl, String twitterUrl, String youtubeUrl){
        clickOnOrangeHrmFooterLink(orangeUrl);
        rightClickOnOrangeHrmFooterLink(orangeUrl);

        clickOnFacebookIconLink(facebookUrl);
        rightClickOnFacebookIconLink(facebookUrl);

        clickOnLinkedinIconLink(linkedinUrl);
        rightClickOnLinkedinIconLink(linkedinUrl);

        clickOnTwitterIconLink(twitterUrl);
        rightClickOnTwitterIconLink(twitterUrl);

        clickOnYoutubeIconLink(youtubeUrl);
        rightClickOnYoutubeIconLink(youtubeUrl);
    }
}
