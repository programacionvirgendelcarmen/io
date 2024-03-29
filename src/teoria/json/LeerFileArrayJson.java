package teoria.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerFileArrayJson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(
                Paths.get("FILES_TEORIA/users.json"))) {
            List<User> users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());
            users.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
