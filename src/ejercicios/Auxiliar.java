package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

public class Auxiliar {

    public static List<Persona> getListPeopleFromFile(String path) throws IOException {
        List<Persona> people = new ArrayList<>();
        //leer con readAllLines que devuelve List<String>
        Path file = Paths.get(path);
        List<String> lines = Files.readAllLines(file);
        //convertir esa lista de String en lista de Persona
        if (lines.isEmpty())
            return people;
        lines.remove(0);  //remove header
        for (String line : lines) {
            String[] tokens = line.split(",");
            people.add(new Persona(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4]));
        }
        return people;
    }
    public static void saveData(List<Persona> people) {

    }
}
