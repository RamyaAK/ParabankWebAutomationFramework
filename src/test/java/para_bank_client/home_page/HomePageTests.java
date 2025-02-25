package para_bank_client.home_page;

import org.testng.annotations.Test;
import para_bank_client.base.BaseTest;

public class HomePageTests extends BaseTest {
    @Test(priority = 0)
    public void testUserOnHomePage() {
        homePage.verifyOnWelcomePage();
    }
}
