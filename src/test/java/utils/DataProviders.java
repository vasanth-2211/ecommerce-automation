package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.io.InputStreamReader;

public class DataProviders {

    @DataProvider(name = "loginUsers")
    public Object[][] loginUsers() {
        InputStream is = DataProviders.class
                .getClassLoader()
                .getResourceAsStream("testdata/loginData.json");
        JsonObject jsonObject = JsonParser
                .parseReader(new InputStreamReader(is))
                .getAsJsonObject();
        JsonArray users = jsonObject.getAsJsonArray("users");
        Object[][] data = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            JsonObject user = users.get(i).getAsJsonObject();
            data[i][0] = user.get("username").getAsString();
            data[i][1] = user.get("password").getAsString();
        }
        return data;
    }
}

