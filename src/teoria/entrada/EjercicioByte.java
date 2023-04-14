package teoria.entrada;

import java.io.*;

public class EjercicioByte {
    public static void main(String[] args) {
        File inFile = new File("FILES/fichero5.txt");
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(inFile))) {
            int b = -1;
            while ( (b = in.read()) != -1){
                System.out.printf("Byte leido: %d, caracter: %c%n",
                        b, (char) b);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
