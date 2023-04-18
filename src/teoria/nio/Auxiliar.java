package teoria.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Auxiliar {

    public static byte[] leerBytes (String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
    public static List<String> leerLineas (String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
    public static boolean escribirBytes(String path, byte[] bytes) throws IOException {
        Path out = Files.write(Paths.get(path), bytes, StandardOpenOption.CREATE);
        return out.toFile().length() == bytes.length;
    }
    public static void escribirLíneas(List<String> lista, String path) throws IOException {
        Path out = Path.of(path);
        if (!Files.exists(out))
            out = Files.createFile(Path.of(path));

        for (String linea : lista) {

            Files.writeString(out, linea + "\n", StandardOpenOption.APPEND);
        }


    }

}
