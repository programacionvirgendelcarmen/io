package teoria.io.salida;

import java.io.*;
import java.util.Scanner;

public class CopiarBytes {
    public static void main(String[] args) {
        File inFile  = new File("FILES/Tux.svg");
        File outFile = new File("FILES/Tux_back.svg");

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(inFile));
             BufferedOutputStream out = new BufferedOutputStream(
                     new FileOutputStream(outFile));)
            {
                int byteLeido = -1;
                while ((byteLeido = in.read()) != -1) {
                    out.write(byteLeido);
                    out.flush();
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Creado backup %s%n", outFile);
    }
}
