package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {

    public static String getData(String object, String key) {
        try {

            InputStream is = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/loginData.json");
            if (is == null) {
                throw new RuntimeException("loginData.json not found in classpath (src/test/resources/testdata/loginData.json)");
            }

            JsonObject jsonObject = JsonParser
                    .parseReader(new InputStreamReader(is))
                    .getAsJsonObject();

            return jsonObject.getAsJsonObject(object).get(key).getAsString();

        } catch (Exception e) {
            throw new RuntimeException("Unable to read JSON test data", e);
        }
    }
}
