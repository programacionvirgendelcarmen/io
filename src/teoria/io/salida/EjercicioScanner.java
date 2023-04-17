package teoria.io.salida;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EjercicioScanner {
    public static void main(String[] args) {
        File inFile = new File("FILES/fichero5.txt");
        try (Scanner in = new Scanner(inFile)) {

            while (in.hasNextLine())
                System.out.println(in.nextLine());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
