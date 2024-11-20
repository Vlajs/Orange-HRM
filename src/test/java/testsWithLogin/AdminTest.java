package testsWithLogin;

import basePage.AdminPage;
import basePage.DashboardPage;
import baseTestWithLogin.BaseTestWithLogin;
import faker.FakerClass;
import methods.AdminMethod;
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
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnSidebarMenuOption("Admin");
        AdminMethod adminMethod = new AdminMethod(driver);
        adminMethod.addAdmin(userRoleText, employeeNameText, statusText, usernameText, passwordText, confirmPasswordText);
        adminMethod.assertSuccessfullyAddedUser(url);
    }
}
