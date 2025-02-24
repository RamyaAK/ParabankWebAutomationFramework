package para_bank_client.login;

import constants.UserDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import para_bank_client.base.BaseTest;


public class LoginTests extends BaseTest {
    UserDetails user = new UserDetails();

    @BeforeTest
    public void initializeUserDetails() {
      String user_name = getProperty("username");
      String password = getProperty("password_value");
      user.setUser_name(user_name);
      user.setPasswordVal(password);
    }

    @Test
    public void UserLoginTest() {
        System.out.println(user.getUser_name());
        System.out.println(user.getPasswordVal());
        String result = homePage.login_with(user.getUser_name(),user.getPasswordVal())
                .VerifyOnLoginPage();
        Assert.assertEquals(result, "Accounts Overview");
    }
}
