package teoria.salida;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EjercicioSinBufferCaracter {
    public static void main(String[] args) {
        File outFile =  new File("FILES/fichero3.txt");
        String mensaje = "otro nuevo mensaje, ahora con tilde ó\n";
        char[] charsMensaje = mensaje.toCharArray();
        System.out.println(Arrays.toString(charsMensaje));
        try (FileWriter out = new FileWriter(outFile)) {
            out.write(charsMensaje);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Escrito fichero %s con %d bytes%n",
                outFile, outFile.length());
    }
}
