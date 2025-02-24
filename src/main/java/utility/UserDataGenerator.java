package utility;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserDataGenerator {
    public static Map<String, String> generateUserData() {
        Faker faker = new Faker();
        Random random = new Random();

        Map<String, String> userData = new HashMap<>();

        userData.put("FirstName", faker.name().firstName());
        userData.put("LastName", faker.name().lastName());
        userData.put("Address", faker.address().streetAddress());

        userData.put("City", faker.address().city());
        userData.put("State", faker.address().state());
        userData.put("ZipCode", faker.address().zipCode());
        userData.put("PhoneNumber", faker.phoneNumber().cellPhone());
        userData.put("SSN", faker.idNumber().ssnValid());

        String username = userData.get("FirstName").toLowerCase() +
                userData.get("LastName").toLowerCase() +
                random.nextInt(1000);
        userData.put("Username", username);

        String password = faker.internet().password(8, 16, true, true, true);
        userData.put("Password", password);
        userData.put("ConfirmPassword", password);

        return userData;
    }
}
