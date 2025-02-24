package para_bank_client.user_registration;

import constants.UserDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import para_bank_client.base.BaseTest;
import utility.UserDataGenerator;

import java.util.Map;

public class NewUserRegistrationTests extends BaseTest {

    UserDetails user = new UserDetails();
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String ssn;
    private String username;
    private String password;
    private String confirm_password;

    private Map<String, String> testData;


    @BeforeClass
    public void PrepareUserTestData() {
        // Calling the utility method to generate user data before the test runs
        testData = UserDataGenerator.generateUserData();
        this.firstName = testData.get("FirstName");
        this.lastName = testData.get("LastName");
        this.address = testData.get("Address");
        this.city = testData.get("City");
        this.state = testData.get("State");
        this.zipCode = testData.get("ZipCode");
        this.phoneNumber = testData.get("PhoneNumber");
        this.ssn = testData.get("SSN");
        this.username = testData.get("Username");
        this.password = testData.get("Password");
        this.confirm_password = testData.get("Password");
        // Optionally, print the generated data to verify
        System.out.println(testData);
    }


    @Test
    public void new_user_registrationTest(){
        System.out.println(firstName);
        homePage.verifyUserOnRegistrationPage();
        String result=homePage.RegisterUserWith(firstName, lastName, address, city, state, zipCode, phoneNumber, ssn, username, password, confirm_password)
                .verifyUserRegistrationSuccessful();
        Assert.assertEquals(result,"Your account was created successfully. You are now logged in.");
    }
}
