package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private  WebDriver driver;
   private By login_page_title = By.tagName("p");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String VerifyOnLoginPage(){
       String loginMsg= driver.findElement(login_page_title).getText();
       return loginMsg;
    }


}
