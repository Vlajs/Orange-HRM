package methods;

import basePage.AdminPage;
import org.openqa.selenium.WebDriver;

public class AdminMethod extends AdminPage {
    public AdminMethod(WebDriver driver) {
        super(driver);
    }

    public AdminMethod addAdmin(String userRoleText, String employeeNameText, String statusText, String usernameText, String passwordText, String confirmPasswordText) throws InterruptedException {
        clickOnAdminAddButton();
        selectInUserRoleField();
        selectAnOptionForUserRole(userRoleText);
        typeInEmployeeNameField(employeeNameText);
        Thread.sleep(2000);
        clickOnFirstOptionEmployeeName();
        clickOnStatusField();
        selectAnOptionForStatus(statusText);
        typeInUsernameField(usernameText);
        typeInPasswordField(passwordText);
        typeInConfirmPasswordField(confirmPasswordText);
        clickOnSaveButton();
        return new AdminMethod(driver);
    }
    public void assertSuccessfullyAddedUser(String url){
        assertSuccessfullyAddedUserForAdminSection();
        assertUrl(url);
    }
}
