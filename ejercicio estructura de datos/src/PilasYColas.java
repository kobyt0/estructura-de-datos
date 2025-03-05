import java.util.Stack;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections; // Importante para invertir la lista

public class PilasYColas
{
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);
        Stack<String> pilaTexto = new Stack<>();
        String textoActual = "", nuevoTexto;
        int opcion;

        while(true)
        {
            System.out.println("Seleccione una opción: (1) Ingresar (2) Deshacer (3) Salir");
            System.out.println("(4) Imprimir texto completo");
            System.out.println("(5) Imprimir desde la pila");
            opcion = lector.nextInt();

            lector.nextLine(); // Consumir el salto de línea
            switch(opcion)
            {
                case 1:
                    System.out.println("Escribe tu texto:");
                    nuevoTexto = lector.nextLine();
                    pilaTexto.push(nuevoTexto);
                    textoActual += nuevoTexto + " "; // Agregar espacio entre palabras
                    break;

                case 2:
                    if(!pilaTexto.isEmpty())
                    {
                        pilaTexto.pop();
                        textoActual = String.join(" ", pilaTexto); // Volver a formar el texto
                    }
                    else
                    {
                        System.out.println("No hay texto para eliminar");
                    }
                    break;

                case 3:
                    System.out.println("Cerrando...");
                    lector.close();
                    return;

                case 4:
                    System.out.println("Texto actual en el editor: " + textoActual);
                    break;

                case 5:
                    if(pilaTexto.isEmpty())
                    {
                        System.out.println("La pila está vacía.");
                    }
                    else
                    {
                        List<String> listaTemporal = new ArrayList<>(pilaTexto);
                        Collections.reverse(listaTemporal); // Invertir la lista para imprimir en orden correcto
                        for (String texto : listaTemporal)
                        {
                            System.out.println(texto);
                        }
                    }
                    break;

                default:
                    System.out.println("Opción no válida...");
            }
        }
    }
}