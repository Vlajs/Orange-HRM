package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSidebarMenuOption(String option){
        By optionBy = By.xpath("//aside[@class='oxd-sidepanel']/nav/div[2]/ul/li/a/span[text()='{option}']"
                .replace("{option}", option));
        clickElement(optionBy, option);
    }
}
