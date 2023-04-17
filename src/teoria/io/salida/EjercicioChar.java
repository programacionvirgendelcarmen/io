package teoria.io.salida;

import java.io.*;

public class EjercicioChar {
    public static void main(String[] args) {
        File inFile = new File("FILES/fichero5.txt");
        try (BufferedReader in = new BufferedReader(new FileReader(inFile))) {

            int c = -1;
            while ( (c = in.read()) != -1){
                System.out.printf("Byte leido: %d, caracter: %c%n",
                        c, (char) c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
