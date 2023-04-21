package teoria.json;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class LeerFileJsonSinMapear {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(
                Paths.get("FILES_TEORIA/user.json"))) {
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
