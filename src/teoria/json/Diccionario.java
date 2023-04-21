package teoria.json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Diccionario {
    public static void main(String[] args) {

        //definiendo un map inmutable
        Map<Integer, String> map = Map.of(0, "pedro garrido" ,
                1, "juan garcía",
                2, "victor sánchez", 3, "gabriel gómez",
                4, "federico pérez", 5, "luisa ayala");
        //map.put(7, "pepa pig"); es inmutable por Map.of
        //recorriendo de forma no segura
        for (int i = 0; i < map.size(); i++) {
            System.out.printf("Clave %d: %S%n",i, map.get(i));
        }
        //preguntando si existe una Key
        System.out.printf("Contiene K = 1: %B%n", map.containsKey(1));
        System.out.printf("Contiene K = 10: %B%n", map.containsKey(10));
        //preguntando si tiene un Value
        System.out.printf("Contiene V = juan garcía: %b%n",
                map.containsValue("juan garcía"));
        System.out.printf("Contiene V = felipe reyes: %b%n",
                map.containsValue("felipe reyes"));
        //obtener un conjunto(Set) de las claves (Key)
        Set<Integer> claves = map.keySet();
        //mostrando usando el toString
        System.out.println(claves);
        //recorriendo el conjuto de claves
        claves.forEach(System.out::println);
        //recorriendo de forma  segura
        for (int clave : claves) {
            System.out.printf("Clave %d: %s%n", clave, map.get(clave));
        }

        //crear un diccionario vacío
        Map<String, String> diccionario = new HashMap<>();
        diccionario.put("12345678a", "luis enrique garcía");
        diccionario.put("12345679a", "pepa pig");
        diccionario.put("12345678b", "samuel beirnstein");
        System.out.println(diccionario);
        System.out.printf("Tamaño diccionario %d%n", diccionario.size());
        diccionario.remove("12345678b");
        System.out.printf("Tamaño diccionario %d%n", diccionario.size());
        diccionario.replace("12345679a", "fernado rey");
        System.out.println(diccionario);

    }
}
