package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AdminPage extends BasePage{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    By adminAddButtonBy = By.xpath("//div[@class='orangehrm-header-container']/button[text()=' Add ']");
    By userRoleFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[1]/div/div[2]/div/div/div[text()='-- Select --']");
    By employeeNameFieldBy = By.xpath("//div[@class='oxd-autocomplete-wrapper']/div/input[@placeholder='Type for hints...']");
    By statusFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[3]/div/div[2]/div/div/div[text()='-- Select --']");
    By usernameFieldBy = By.xpath("//form[@class='oxd-form']/div/div/div[4]/div/div[2]/input[contains(@class, 'oxd-input oxd-input--')]");
    By passwordFieldBy = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[1]/div/div[2]/input[@type='password']");
    By confirmPasswordFieldBy = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input[@type='password']");
    By cancelButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[1][text()=' Cancel ']");
    By saveButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[2][text()=' Save ']");
    By firstOptionEmployeeNameBy = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div[1]");
    By successfullyAddedUserWidgetBy = By.xpath("//div[@id='oxd-toaster_1']");

    public void selectAnOptionForUserRole(String optionText){
        clickElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div[3]/span[text()='{OPTION}']".replace("{OPTION}", optionText)), optionText);
    }
    public void selectAnOptionForStatus(String optionText){
        clickElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div/span[text()='{OPTION}']".replace("{OPTION}", optionText)), optionText);
    }

    public void clickOnFirstOptionEmployeeName(){
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstOptionEmployeeNameBy));
        clickElement(firstOptionEmployeeNameBy, "firstOptionEmployeeNameBy");
    }
    public void clickOnAdminAddButton(){
        clickElement(adminAddButtonBy, "adminAddButtonBy");
    }
    public void selectInUserRoleField(){
        clickElement(userRoleFieldBy, "userRoleFieldBy");
    }
    public void typeInEmployeeNameField(String employeeNameFieldText){
        writeText(employeeNameFieldBy, employeeNameFieldText, "employeeNameFieldBy");
    }
    public void clickOnStatusField(){
        clickElement(statusFieldBy, "statusFieldBy");
    }
    public void typeInUsernameField(String usernameFieldText){
        writeText(usernameFieldBy, usernameFieldText, "usernameFieldBy");
    }
    public void typeInPasswordField(String passwordFieldText){
        writeText(passwordFieldBy, passwordFieldText, "passwordFieldBy");
    }
    public void typeInConfirmPasswordField(String userRoleText){
        writeText(confirmPasswordFieldBy, userRoleText, "confirmPasswordFieldBy");
    }
    public void clickOnSaveButton(){
        clickElement(saveButtonBy, "saveButtonBy");
    }
    public void clickOnCancelButton(){
        clickElement(cancelButtonBy, "cancelButtonBy");
    }

    public void addAdmin(String userRoleText, String employeeNameText, String statusText, String usernameText, String passwordText, String confirmPasswordText) throws InterruptedException {
        clickOnAdminAddButton();
        selectInUserRoleField();
        selectAnOptionForUserRole(userRoleText);
        typeInEmployeeNameField(employeeNameText);/*
        Thread.sleep(2000);*/
        clickOnFirstOptionEmployeeName();
        clickOnStatusField();
        selectAnOptionForStatus(statusText);
        typeInUsernameField(usernameText);
        typeInPasswordField(passwordText);
        typeInConfirmPasswordField(confirmPasswordText);
        clickOnSaveButton();
    }
    public void assertSuccessfullyAddedUserForAdminSection(String url){
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}
