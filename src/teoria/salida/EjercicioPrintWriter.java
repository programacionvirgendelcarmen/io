package teoria.salida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EjercicioPrintWriter {
    public static void main(String[] args) {
        File outFile = new File("FILES/fichero5.txt");
        String mensaje = "mensaje a escribir";
        try (PrintWriter out = new PrintWriter(outFile)) {
            out.printf("mensaje: %S, nº de caracteres %d%n",
                    mensaje, mensaje.length());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Escrito fichero %s con %d bytes%n",
                outFile, outFile.length());
    }
}
