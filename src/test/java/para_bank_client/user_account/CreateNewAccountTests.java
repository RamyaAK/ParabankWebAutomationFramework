package para_bank_client.user_account;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import para_bank_client.base.BaseTest;
import utility.TestDataJsonManager;

import java.io.IOException;
import java.util.Map;

public class CreateNewAccountTests extends BaseTest {
    private String savedUsername;
    private String savedPassword;
    private String saved_account_id;

    @BeforeTest
    public void initializeUserDetails() throws IOException {
        // Step 1: Load credentials from JSON
        Map<String, String> credentials = TestDataJsonManager.loadUserCredentials();
        this.savedUsername = credentials.get("username");
        this.savedPassword = credentials.get("password");

    }

    @Test
    public void createNewAccountTest() {
        homePage.verifyOnWelcomePage()
                .login_with(savedUsername, savedPassword);
        loginPage.VerifyOnLoginPage();
        accountServicesPage.selectOpenNewAccount();
        String account_id = openNewAccountPage.selectAccountTypeAs("SAVINGS")
                .clickOnOpenNewAccount()
                .getNewAccountId();
        Assert.assertNotNull(account_id);
        this.saved_account_id =account_id;
        System.out.println(saved_account_id);
    }
}
