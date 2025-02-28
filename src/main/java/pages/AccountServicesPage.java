package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountServicesPage {
    private WebDriver driver;
    private By open_new_account_link = By.cssSelector("a[href='openaccount.htm']");
    private By accounts_overview = By.linkText("Accounts Overview");
    private By transfer_funds = By.linkText("Transfer Funds");
    private By billpay = By.linkText("Bill Pay");
    private By find_transaction = By.linkText("Find Transactions");
    private By update_contact_info = By.linkText("Update Contact Info");
    private By request_loan = By.linkText("Request Loan");
    private By log_out = By.linkText("Log Out");


    public AccountServicesPage(WebDriver driver) {
        this.driver = driver;
    }

    public OpenNewAccountPage selectOpenNewAccount(){
        driver.findElement(open_new_account_link).click();
        return new OpenNewAccountPage(driver);
    }
}
