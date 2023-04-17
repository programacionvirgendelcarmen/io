package teoria.nio;

public class Test {
    public static void main(String[] args) {
            String fichero1 = "FILES/Tux.svg";
            byte[] bytesFichero1 = Auxiliar.leerBytes(fichero1);
        System.out.printf("%s tiene %d bytes%n",
                fichero1, bytesFichero1.length );
    }
}
