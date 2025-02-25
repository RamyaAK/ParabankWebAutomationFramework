package utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataJsonManager {
    private static final String FILE_PATH = "src/temp/user_details.json"; // Writable directory
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Save user credentials in JSON file
    public static void saveUserCredentials(String username, String password) throws IOException {
        Map<String, String> userData = new HashMap<>();
        userData.put("username", username);
        userData.put("password", password);

        // Write JSON to file
        objectMapper.writeValue(new File(FILE_PATH), userData);
    }

    // Load user credentials from JSON file
    public static Map<String, String> loadUserCredentials() throws IOException {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            throw new IOException("Test data file not found!");
        }

        // Read JSON file and return as a Map
        return objectMapper.readValue(file, Map.class);
    }
}
