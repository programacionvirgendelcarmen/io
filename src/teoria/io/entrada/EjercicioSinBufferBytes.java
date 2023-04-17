package teoria.io.entrada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class EjercicioSinBufferBytes {
    public static void main(String[] args) {
        //declarar el fichero
        File outFile = new File("FILES/fichero1.txt");
        //declarar el contenido
        String mensaje = "Esto un mensaje que se va a guardar en un fichero\nFin de fichero\n";
        byte[] bytesMensaje = mensaje.getBytes();
        System.out.println(Arrays.toString(bytesMensaje));
        //abrir flujo
        try (FileOutputStream out = new FileOutputStream(outFile, true)) {
            //escribir en el flujo
            out.write(bytesMensaje);
            out.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //cerrar el flujo : se cierra solo
        System.out.printf("Escrito fichero %s con %d bytes%n",
                outFile, outFile.length());
    }
}
