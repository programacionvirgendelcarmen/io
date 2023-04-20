package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Personal {
    private List<Persona> people;
    //Un constructor para inicializar la colección de objetos Persona
    public Personal(List<Persona> personas) {
        this.people = personas;
    }

    public List<Persona> getPeople() {
        return people;
    }

    //Un método que nos sirva para añadir objetos Persona
    public boolean addPerson (Persona person){
        return people.add(person);
    }
    //Un método que devuelva una lista de objetos Persona dado como argu-
    //mento el paı́s al que pertenence.
    public  List<Persona> getPeopleByCountry(String country) {
        List<Persona> listOfCountry = new ArrayList<>();
        for (Persona person : people) {
            if (person.getCountry().equalsIgnoreCase(country))
                listOfCountry.add(person);
        }
        return listOfCountry;
    }

    //método que borre un objeto Persona dado como argumento el email
    //de la misma.
    public boolean removePersonByEmail (String email) {
        for (Persona person : people) {
            if (person.getEmail().equalsIgnoreCase(email))
                return people.remove(person);
        }
        return false;
    }


}
