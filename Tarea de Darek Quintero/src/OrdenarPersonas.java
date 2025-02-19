import java.util.Arrays;
import java.util.Comparator;

class Persona {
    String nombre;
    int edad;


    public Persona(String nombre, int edad){
        this.nombre = nombre; this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " tiene " + edad + " años";
    }
}

public class OrdenarPersonas {
    public static void main(String[] args) {
        Persona[] personas = new Persona[4];
        personas[0] = new Persona("Carlos", 25);
        personas[1] = new Persona("ana", 30); // No puse mayúscula, afecta el orden
        personas[2] = new Persona("Pedro", 20);
        personas[3] = new Persona("Beatriz ", 22);

        Arrays.sort(personas, Comparator.comparing(p -> p.nombre)); // Ordena por nombre

        System.out.println("Ordenado por nombre:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        Arrays.sort(personas, Comparator.comparingInt(p -> p.edad)); // Ordena por edad

        System.out.println("\nOrdenado por edad:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}
