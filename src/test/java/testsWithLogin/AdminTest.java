package testsWithLogin;

import basePage.AdminPage;
import basePage.DashboardPage;
import baseTestWithLogin.BaseTestWithLogin;
import faker.FakerClass;
import org.testng.annotations.Test;

public class AdminTest extends BaseTestWithLogin {
    @Test
    public void adminAddUserTest() throws InterruptedException {
        String userRoleText = "ESS";
        String employeeNameText = "a";
        String statusText = "Enabled";
        String usernameText = FakerClass.fakeWord();
        String passwordText = "Password123";
        String confirmPasswordText = passwordText;
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnSidebarMenuOption("Admin");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.addAdmin(userRoleText, employeeNameText, statusText, usernameText, passwordText, confirmPasswordText);
    }
}
