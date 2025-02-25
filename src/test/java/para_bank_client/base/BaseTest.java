package para_bank_client.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        ChromeDriver driver = new ChromeDriver();
        this.driver = driver;
        initializePageObjects();
        launchUrl(driver);
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
