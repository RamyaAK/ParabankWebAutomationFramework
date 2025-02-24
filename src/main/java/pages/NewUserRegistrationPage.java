package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewUserRegistrationPage {
    private WebDriver driver;
    private By welcome_message = By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]");
    private By logout_button = By.linkText("Log Out");


    public NewUserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyUserRegistrationSuccessful(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Waiting for 10 seconds
        WebElement logoutButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button));

        if(logoutButtonElement.isDisplayed()){
            System.out.println("User Logged In, Log Out button is visible.");
        }else{
            System.out.println("User not able to login, Log Out button is also not visible.");
        }

        String welcome_msg = driver.findElement(welcome_message).getText();
        return welcome_msg;
    }


}
