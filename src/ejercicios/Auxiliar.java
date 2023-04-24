package ejercicios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
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
    public static List<Persona> getListPeopleFromJSON (String path) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(path));
        List<Persona> personas = new Gson().fromJson(reader, new TypeToken<List<Persona>>() {}.getType());

        return personas;
    }
    public static List<Persona> getListPeopleFromXML(String path) throws IOException, SAXException, ParserConfigurationException {
        List<Persona> personas = new ArrayList<>();
        File inputFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("persona");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String firstName = eElement
                        .getElementsByTagName("firstName")
                        .item(0)
                        .getTextContent();
                String lastName = eElement
                        .getElementsByTagName("lastName")
                        .item(0)
                        .getTextContent();
                String email = eElement
                        .getElementsByTagName("email")
                        .item(0)
                        .getTextContent();
                String gender = eElement
                        .getElementsByTagName("gender")
                        .item(0)
                        .getTextContent();
                String country = eElement
                        .getElementsByTagName("country")
                        .item(0)
                        .getTextContent();
                personas.add(new Persona(firstName, lastName, email,
                        gender, country));
            }
        }
        return personas;
    }

}
