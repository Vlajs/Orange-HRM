package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    By adminAddButtonBy = By.xpath("//div[@class='orangehrm-header-container']/button[text()=' Add ']");
    By userRoleFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[1]/div/div[2]/div/div/div[text()='-- Select --']");
    By employeeNameFieldBy = By.xpath("//div[@class='oxd-autocomplete-wrapper']/div/input[@placeholder='Type for hints...']");
    By statusFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[3]/div/div[2]/div/div/div[text()='-- Select --']");
    By usernameFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[4]/div/div[2]/input[@class='oxd-input oxd-input--active']");
    By passwordFieldBy = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[1]/div/div[2]/input[@type='password']");
    By confirmPasswordFieldBy = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input[@type='password']");
    By cancelButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[1][text()=' Cancel ']");
    By saveButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[2][text()=' Save ']");

    public void clickOnAdminAddButton(){
        clickElement(adminAddButtonBy, "adminAddButtonBy");
    }
    public void typeInStatusField(String statusFieldText){
        writeText(statusFieldBy, statusFieldText, "statusFieldBy");
    }
    public void typeInEmployeeNameField(String employeeNameFieldText){
        writeText(employeeNameFieldBy, employeeNameFieldText, "employeeNameFieldBy");
    }
    public void typeInUsernameField(String usernameFieldText){
        writeText(usernameFieldBy, usernameFieldText, "usernameFieldBy");
    }
    public void typeInPasswordField(String passwordFieldText){
        writeText(passwordFieldBy, passwordFieldText, "passwordFieldBy");
    }
    public void typeInUserRoleField(String userRoleText){
        writeText(userRoleFieldBy, userRoleText, "userRoleFieldBy");
    }
    public void typeInConfirmPasswordField(String userRoleText){
        writeText(usernameFieldBy, userRoleText, "usernameFieldBy");
    }

}
