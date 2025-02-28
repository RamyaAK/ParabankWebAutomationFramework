package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage {
    protected WebDriver driver;
    private By create_new_account_button = By.tagName("input");
    private By acc_opened_heading = By.cssSelector("div[id='openAccountResult'] h1[class='title']");
    private By acc_open_success_msg = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");
    private By new_account_id = By.id("newAccountId");


    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public OpenNewAccountPage selectAccountTypeAs(String value) {
        Select account_typ = new Select(driver.findElement(By.cssSelector("#type")));
        account_typ.selectByContainsVisibleText(value);
        return new OpenNewAccountPage(driver);
    }

    public OpenNewAccountPage clickOnOpenNewAccount() {
        driver.findElement(create_new_account_button).click();
        return new OpenNewAccountPage(driver);
    }

    public OpenNewAccountPage verifyIfAccountOpenedSuccessfully(){
         driver.findElement(acc_opened_heading).isDisplayed();
         driver.findElement(acc_open_success_msg).isDisplayed();
         return new OpenNewAccountPage(driver);
    }

    public String getNewAccountId(){
        return driver.findElement(new_account_id).getText();
    }

}
