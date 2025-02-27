package para_bank_client.user_login;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import para_bank_client.base.BaseTest;
import utility.TestDataJsonManager;

import java.io.IOException;
import java.util.Map;


public class LoginTests extends BaseTest {

    private String savedUsername;
    private String savedPassword;

    @BeforeTest
    public void initializeUserDetails() throws IOException {
        // Step 1: Load credentials from JSON
        Map<String, String> credentials = TestDataJsonManager.loadUserCredentials();
        this.savedUsername = credentials.get("username");
        this.savedPassword = credentials.get("password");
    }

    @Test(priority = 2)
    public void UserLoginTest() {
        System.out.println(savedUsername);
        System.out.println(savedPassword);
        String result = homePage.login_with(savedUsername, savedPassword)
                .VerifyOnLoginPage();
        Assert.assertEquals(result, "Accounts Overview");
    }
}
