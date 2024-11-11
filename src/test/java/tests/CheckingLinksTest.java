package tests;

import baseTest.BaseTest;
import methods.LandingMethod;
import org.testng.annotations.Test;

public class CheckingLinksTest extends BaseTest {
    @Test
    public void checkingLinksTest(){
        String orangeUrl = "https://www.orangehrm.com/";
        String linkedinUrl = "https://www.linkedin.com/company/orangehrm";
        String facebookUrl = "https://www.facebook.com/OrangeHRM/";
        String twitterUrl = "https://x.com/orangehrm?lang=en";
        String youtubeUrl = "https://www.youtube.com/c/OrangeHRMInc";
        LandingMethod landingMethod = new LandingMethod(driver);
        landingMethod.checkingLinks(orangeUrl, linkedinUrl, facebookUrl, twitterUrl, youtubeUrl);
    }
}
