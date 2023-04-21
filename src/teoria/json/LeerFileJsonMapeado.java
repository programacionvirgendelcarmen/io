package teoria.json;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeerFileJsonMapeado {
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (Reader reader = Files.newBufferedReader(
                Paths.get("FILES_TEORIA/user.json"))) {
            User user = gson.fromJson(reader, User.class);
            System.out.println(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
