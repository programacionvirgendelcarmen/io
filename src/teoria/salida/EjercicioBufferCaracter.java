package teoria.salida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioBufferCaracter {
    public static void main(String[] args) {
        File outFile = new File("FILES/fichero4.txt");
        String mensaje1 = "hola, primero mensaje\n";
        String mensaje2 = "hello, second message\n";
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(outFile))) {
            out.write(mensaje1.toCharArray());
            out.write(mensaje2.toCharArray());
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Escrito fichero %s con %d bytes%n",
                outFile, outFile.length());
    }

}
