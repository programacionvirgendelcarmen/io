package teoria.io.entrada;

import java.io.*;

public class EjercicioBufferBytes {
    public static void main(String[] args) {
        File outFile = new File("FILES/fichero2.txt");
        String mensaje = "otro mensaje a ecribir con eñe\n";

        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(outFile))) {
            out.write(mensaje.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Escrito fichero %s con %d bytes%n",
                outFile, outFile.length());
    }
}
