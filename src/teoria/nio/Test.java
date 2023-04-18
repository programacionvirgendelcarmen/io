package teoria.nio;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String fichero1 = "FILES/Tux.svg";
        byte[] bytesFichero1 = null;
        String fichero2 = "FILES/Quijote.txt";
        List<String> lineas = null;
        String linea = "escribiendo en fichero";
        String nuevoFichero = "FILES/nuevo.txt";
        boolean exito1 = false;
        List<String> cadenas = List.of("uno", "dos", "tres");

        try {
            bytesFichero1 = Auxiliar.leerBytes(fichero1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            lineas = Auxiliar.leerLineas(fichero2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            exito1 = Auxiliar.escribirBytes(
                    nuevoFichero, linea.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
           Auxiliar.escribirLíneas(cadenas, "FILES/cadenas.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (bytesFichero1 != null)
            System.out.printf("%s tiene %d bytes%n",
                fichero1, bytesFichero1.length );

        if (lineas != null)
            System.out.printf("El fichero %s tiene %d líneas%n",
                fichero2, lineas.size());
        System.out.printf("Copiado la línea %B%n", exito1);


    }
}
