package teoria.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Copiar {

    public static void main(String[] args) {

        File inFile  = new File("FILES/Quijote.txt");
        File outFile = new File("FILES/Quijote_back.txt");

        try (Scanner in = new Scanner(inFile);
             PrintWriter out = new PrintWriter(outFile)) {
            while (in.hasNextLine()) {
                String linea = in.nextLine();
                out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Creado backup %s%n", outFile);

    }

}
