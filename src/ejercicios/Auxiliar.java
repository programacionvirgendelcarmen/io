package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

public class Auxiliar {

    public static List<Persona> getListPeopleFromCSV(String path) throws IOException {
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
    public static void saveDataAsCSV(List<Persona> people) throws IOException {
        //personal_10-3-2022_12:15.csv
        LocalDateTime now = LocalDateTime.now();
        StringBuilder builder = new StringBuilder("personal_");
        builder.append(now.getDayOfMonth()).append('-');
        builder.append(now.getMonthValue()).append('-');
        builder.append(now.getYear()).append('_');
        builder.append(now.getHour()).append(':');
        builder.append(now.getMinute()).append(".csv");
        String sPath = "FILES_EJERCICIOS/" + builder.toString();
        Path out = Path.of(sPath);
        if (!Files.exists(out))
            out = Files.createFile(Path.of(sPath));
        Files.writeString(out, "firstName,lastName,email,gender,country",
                StandardOpenOption.APPEND);
        for (Persona person : people) {
            Files.writeString(out, person + "\n", StandardOpenOption.APPEND);
        }

    }
    public static List<Persona> getListPeopleFromJSON (String path) {
        return null;
    }
}
