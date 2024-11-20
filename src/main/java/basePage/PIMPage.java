package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage{
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    By pimAddButtonBy = By.xpath("//div[@class='orangehrm-header-container']/button[text()=' Add ']");
    By createLoginDetailsButtonBy = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
    By firstNameFieldBy = By.xpath("//input[@placeholder='First Name']");
    By middleNameFieldBy = By.xpath("//input[@placeholder='Middle Name']");
    By lastNameFieldBy = By.xpath("//input[@placeholder='Last Name']");
    By employeeIdFieldBy = By.xpath("//form[@class='oxd-form']/div/div[2]/div/div[2]/div/div/div[2]/input[@class='oxd-input oxd-input--active']");
    By usernameFieldBy = By.xpath("//form[@class='oxd-form']/div/div[2]/div[3]/div/div/div/div[2]/input");
    By statusEnabledButtonBy = By.xpath("//div[@class='--status-grouped-field']/div[1]/div[2]/div/label/input");
    By statusDisabledButtonBy = By.xpath("//div[@class='--status-grouped-field']/div[2]/div[2]/div/label/input");
    By passwordFieldBy = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/div/div[2]/input[@type='password']");
    By confirmPasswordFieldBy = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']/div/div[2]/input[@type='password']");
    By cancelButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[1][@type='button']");
    By saveButtonBy = By.xpath("//div[@class='oxd-form-actions']/button[2][@type='submit']");

    public void clickOnPimAddButton(){
        clickElement(pimAddButtonBy, "pimAddButtonBy");
    }
    public void typeTextInFirstNameField(String firstNameText){
        writeText(firstNameFieldBy, firstNameText, "first name");
    }
    public void typeTextInMiddleNameField(String middleNameText){
        writeText(middleNameFieldBy, middleNameText, "middle name");
    }
    public void typeTextInLastNameField(String lastNameText){
        writeText(lastNameFieldBy, lastNameText, "last name");
    }
    public void selectCreateLoginDetailsButton(){
        if (!assertElementIsSelected(createLoginDetailsButtonBy)){
            clickElement(createLoginDetailsButtonBy, "createLoginDetailsButtonBy");
        }
    }
    public void typeTextInUsernameField(String usernameText){
        writeText(usernameFieldBy, usernameText, "username");
    }
    public void selectStatusToBeEnabled(){
        if (!assertElementIsSelected(statusEnabledButtonBy)){
            clickElement(statusEnabledButtonBy, "status enabled");
        }
    }
    public void typeTextInPasswordField(String passwordText){
        writeText(passwordFieldBy, passwordText, "password");
    }
    public void typeTextInConfirmPasswordField(String confirmPasswordText){
        writeText(confirmPasswordFieldBy, confirmPasswordText, "confirm password");
    }
    public void clickOnCancelButton(){
        clickElement(cancelButtonBy, "cancel button");
    }
    public void clickOnSaveButton(){
        clickElement(saveButtonBy, "save button");
    }
}
