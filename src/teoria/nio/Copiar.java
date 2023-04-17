package teoria.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copiar {
    public static void main(String[] args) {

        Path inPath  = Paths.get("FILES/io4.pdf");
        Path outPath = Paths.get("FILES/io4_back.pdf");

        try {
            Files.copy(inPath, outPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
