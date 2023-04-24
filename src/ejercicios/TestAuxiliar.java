package ejercicios;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestAuxiliar {
    private static List<Persona> people = null;
    private static Personal personal = null;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            people = Auxiliar.getListPeopleFromJSON(
                    "FILES_EJERCICIOS/personal.json");
          //  System.out.println(people);
        } catch (IOException e) {
            System.out.printf("No existe el fichero %s%n" , e.getMessage());
            return;
        }
        personal = new Personal(people);

        while (true) {
            int opcion = getOption();
            switch (opcion) {
                case 0:
                    System.out.println("Cerrando al aplicación");
                    scanner.close();
                    try {
                        Auxiliar.saveDataAsCSV(personal.getPeople());
                    } catch (IOException e) {
                        System.out.printf("Problema con %s%n", e.getMessage());
                    }
                    return;
                case 1:
                    listarPersonasPorPais();
                    break;
                case 2:
                    borrarPersonaPorEmail();
                    break;
                default:
                    return;
            }
        }

    }


    private static void borrarPersonaPorEmail() {
        System.out.println("Introduce un email válido");
        String email = "";
        do {
            email = scanner.nextLine();
        } while (! email.toLowerCase().matches(".+@.+\\.[a-z]+"));
        boolean existePersona = personal.removePersonByEmail(email);
        if (! existePersona)
            System.out.printf("No existe persona con el email %s%n", email);
        else
            System.out.printf("Borrada persona con el email %s%n", email);
    }

    private static void listarPersonasPorPais() {
        System.out.println("Introduce país: ");
        String country = scanner.nextLine();
        List<Persona> personas = personal.getPeopleByCountry(country);
        if (personas.isEmpty())
            System.out.println("No hay personas que mostrar");
        else {
            System.out.printf("listando personas del país %S%n", country);
            personas.forEach(System.out::println);
        }
    }

    private static int getOption() {
        StringBuilder builder = new StringBuilder();
        builder.append("[0] Salir").append('\n');
        builder.append("[1] Listar personas por país").append('\n');
        builder.append("[2] Borrar persona por email").append("\n\n");
        builder.append("Introduce opción:  ");
        String sOpcion = "-1";
        do {
            System.out.println(builder.toString());
            sOpcion = scanner.nextLine();
        } while (!sOpcion.matches("[0-2]"));
        return Integer.parseInt(sOpcion);
    }
}
