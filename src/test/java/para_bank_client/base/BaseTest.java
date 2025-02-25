package para_bank_client.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewUserRegistrationPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private static final Properties properties;
    private WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected NewUserRegistrationPage newUserRegistrationPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Generate a unique user data directory using the current time
        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome_profile_" + System.currentTimeMillis();  // Unique user data directory
        options.addArguments("--user-data-dir=" + userDataDir);

        options.addArguments("--disable-dev-shm-usage");  // Helps in Docker/Linux environments
        options.addArguments("--no-sandbox"); // Helps in CI/CD pipelines

        // Initialize the driver with options
        this.driver = new ChromeDriver(options);

        initializePageObjects();
        launchUrl((ChromeDriver) driver);
    }



    // Load properties file once for reading user details from user.properties file
    static {
        properties = new Properties();
        try {
            FileInputStream fileInput = new FileInputStream("src/main/resources/user.properties");
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load user.properties file");
        }
    }

    // Generic method to fetch property values
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void launchUrl(ChromeDriver driver) {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    private void initializePageObjects() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newUserRegistrationPage = new NewUserRegistrationPage(driver);

    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing the Tests, Thank you!");
    }


}
