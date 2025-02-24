package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By title_name = By.cssSelector(".logo");
    private By user_name = By.name("username");
    private By pass = By.name("password");
    private By login_btn = By.xpath("//input[@value='Log In']");


    private By first_name = By.cssSelector("input[id='customer.firstName']");
    private By last_name = By.id("customer.lastName");
    private By addrs = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipcode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By customer_username = By.id("customer.username");
    private By customer_password = By.id("customer.password");
    private By confirm_password = By.id("repeatedPassword");
    private By register_button = By.cssSelector("input[value='Register']");
    private By registrationpagemessage = By.cssSelector("div[id='rightPanel'] p");
    private By registerLink = By.linkText("Register");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage verifyOnWelcomePage() {
        driver.findElement(title_name);
        return new HomePage(driver);
    }

    public LoginPage login_with(String username, String password) {
        driver.findElement(user_name).sendKeys(username);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(login_btn).click();
        return new LoginPage(driver);
    }

    public NewUserRegistrationPage verifyUserOnRegistrationPage() {
        driver.findElement(registerLink).click();
        boolean val = driver.findElement(registrationpagemessage).isDisplayed();
        System.out.println(val);
        return new NewUserRegistrationPage(driver);
    }

    public NewUserRegistrationPage RegisterUserWith(String firstname, String lastname, String address, String cty, String stat, String zpcode, String phn, String sn, String username, String password, String confirm) {
        driver.findElement(first_name).sendKeys(firstname);
        driver.findElement(last_name).sendKeys(lastname);
        driver.findElement(addrs).sendKeys(address);
        driver.findElement(city).sendKeys(cty);
        driver.findElement(state).sendKeys(stat);
        driver.findElement(zipcode).sendKeys(zpcode);
        driver.findElement(phone).sendKeys(phn);
        driver.findElement(ssn).sendKeys(sn);
        driver.findElement(customer_username).sendKeys(username);
        driver.findElement(customer_password).sendKeys(password);
        driver.findElement(confirm_password).sendKeys(confirm);
        driver.findElement(register_button).click();

        return new NewUserRegistrationPage(driver);
    }


}
