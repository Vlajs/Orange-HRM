package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    By usernameFieldBy = By.xpath("//input[@name='username']");
    By passwordFieldBy = By.xpath("//input[@name='password']");
    By loginButtonBy = By.xpath("//button[@type='submit']");
    By errorMessageBy = By.xpath("//div[@class='orangehrm-login-error']//p[text()='Invalid credentials']");
    By usernameErrorMessageBy = By.xpath("//form[@class='oxd-form']//div[1]/div/span");
    By passwordErrorMessageBy = By.xpath("//form[@class='oxd-form']//div[2]/div/span");
    By forgotPasswordLinkBy = By.xpath("//div[@class='orangehrm-login-form']/form/div[4]/p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    By forgotPasswordUsernameFieldBy = By.xpath("//div[@class='oxd-form-row']/div/div[2]/input[@name='username']");
    By cancelResetPasswordButtonBy = By.xpath("//div[@class='orangehrm-forgot-password-button-container']/button[1][text()=' Cancel ']");
    By resetPasswordButtonBy = By.xpath("//div[@class='orangehrm-forgot-password-button-container']/button[2][text()=' Reset Password ']");
    By resetPasswordTextAssertBy = By.xpath("//div[@class='orangehrm-card-container']/h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");
    By orangeHrmFooterLinkBy = By.xpath("//div[@class='orangehrm-login-footer']/div[2]/p[2]/a[@href='http://www.orangehrm.com']");
    By linkedingLinkBy = By.xpath("//div[@class='orangehrm-login-footer-sm']/a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']");
    By facebookIconLinkBy = By.xpath("//div[@class='orangehrm-login-footer-sm']/a[@href='https://www.facebook.com/OrangeHRM/']");
    By twitterIconLinkBy = By.xpath("//div[@class='orangehrm-login-footer-sm']/a[@href='https://twitter.com/orangehrm?lang=en']");
    By youtubeIconLinkBy = By.xpath("//div[@class='orangehrm-login-footer-sm']/a[@href='https://www.youtube.com/c/OrangeHRMInc']");


    public void clickOnOrangeHrmFooterLink(String orangeUrl){
        clickElement(orangeHrmFooterLinkBy, "orangeHrmFooterLinkBy");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertUrl(orangeUrl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void rightClickOnOrangeHrmFooterLink(String url){
        performRightClick(orangeHrmFooterLinkBy, url, "orangeHrmFooterLinkBy");
    }

    public void clickOnLinkedinIconLink(String instagramUrl){
        clickElement(linkedingLinkBy, "linkedinIconLinkBy");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertUrl(instagramUrl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void rightClickOnLinkedinIconLink(String url){
        performRightClick(linkedingLinkBy, url, "linkedinIconLinkBy");
    }

    public void clickOnFacebookIconLink(String facebookUrl){
        clickElement(facebookIconLinkBy, "facebookIconLinkBy");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertUrl(facebookUrl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void rightClickOnFacebookIconLink(String url){
        performRightClick(facebookIconLinkBy, url, "facebookIconLinkBy");
    }

    public void clickOnTwitterIconLink(String twitterUrl){
        clickElement(twitterIconLinkBy, "twitterIconLinkBy");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertUrl(twitterUrl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void rightClickOnTwitterIconLink(String url){
        performRightClick(twitterIconLinkBy, url, "twitterIconLinkBy");
    }

    public void clickOnYoutubeIconLink(String youtubeUrl){
        clickElement(youtubeIconLinkBy, "youtubeIconLinkBy");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertUrl(youtubeUrl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    public void rightClickOnYoutubeIconLink(String url){
        performRightClick(youtubeIconLinkBy, url, "youtubeIconLinkBy");
    }

    public void typeInUsernameField(String usernameText){
        writeText(usernameFieldBy, usernameText, "usernameFieldBy");
    }
    public void typeInPasswordField(String passwordText){
        writeText(passwordFieldBy, passwordText, "passwordFieldBy");
    }
    public void clickOnLoginButton(){
        clickElement(loginButtonBy, "loginButtonBy");
    }
    public void assertPage(String url){
        driverWait.until(ExpectedConditions.urlToBe(url));
        assertUrl(url);
    }
    public void clickOnForgotPasswordLink(){
        clickElement(forgotPasswordLinkBy, "forgotPasswordLinkBy");
    }
    public void typeTextInUsernameResetPasswordField(String usernameResetPasswordText){
        writeText(forgotPasswordUsernameFieldBy, usernameResetPasswordText, "forgotPasswordUsernameFieldBy");
    }
    public void clickOnCancelResetPasswordButton(){
        clickElement(cancelResetPasswordButtonBy, "cancelResetPasswordButtonBy");
    }
    public void clickOnResetPasswordButton(){
        clickElement(resetPasswordButtonBy, "resetPasswordButtonBy");
    }
    public void assertWrongData(String errorText){
        assertText(errorMessageBy, errorText);
    }
    public void assertEmptyUsernameField(String errorText){
        assertText(usernameErrorMessageBy, errorText);
    }
    public void assertEmptyPasswordField(String errorText){
        assertText(passwordErrorMessageBy, errorText);
    }
    public void assertResetPasswordText(String resetPasswordText){
        assertText(resetPasswordTextAssertBy, resetPasswordText);
    }
}
