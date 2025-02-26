import java.util.Scanner;
import java.util.Arrays;

public class ProductosApp {

    static String[] codigos = new String[10];
    static String[] nombres = new String[10];
    static double[] precios = new double[10];
    static int[] cantidades = new int[10];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto por Código");
            System.out.println("3. Ordenar por Precio");
            System.out.println("4. Ordenar por Cantidad");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                agregarProducto(sc);
            } else if (opcion == 2) {
                buscarProducto(sc);
            } else if (opcion == 3) {
                ordenarPorPrecio();
                imprimirProductos();
            } else if (opcion == 4) {
                ordenarPorCantidad();
                imprimirProductos();
            } else if (opcion == 5) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida, intente otra vez.");
            }
        }
        sc.close();
    }

    public static void agregarProducto(Scanner sc) {
        if (contador >= 10) {
            System.out.println("Lista llena, no se pueden agregar más productos.");
            return;
        }
        sc.nextLine();
        System.out.print("Código: ");
        codigos[contador] = sc.nextLine();
        System.out.print("Nombre: ");
        nombres[contador] = sc.nextLine();
        System.out.print("Precio: ");
        precios[contador] = sc.nextDouble();
        System.out.print("Cantidad: ");
        cantidades[contador] = sc.nextInt();
        contador++;
        System.out.println("Producto agregado correctamente!");
    }

    public static void buscarProducto(Scanner sc) {
        sc.nextLine();
        System.out.print("Ingrese el código del producto: ");
        String codigoBuscado = sc.nextLine();

        for (int i = 0; i < contador; i++) {
            if (codigos[i].equals(codigoBuscado)) {
                System.out.println("Producto encontrado: " + nombres[i] + " - $" + precios[i] + " - " + cantidades[i] + " unidades");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void ordenarPorPrecio() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (precios[j] > precios[j + 1]) {
                    double tempPrecio = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = tempPrecio;

                    int tempCantidad = cantidades[j];
                    cantidades[j] = cantidades[j + 1];
                    cantidades[j + 1] = tempCantidad;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;

                    String tempCodigo = codigos[j];
                    codigos[j] = codigos[j + 1];
                    codigos[j + 1] = tempCodigo;
                }
            }
        }
        System.out.println("Productos ordenados por precio.");
    }

    public static void ordenarPorCantidad() {
        for (int i = 1; i < contador; i++) {
            double keyPrecio = precios[i];
            int keyCantidad = cantidades[i];
            String keyNombre = nombres[i];
            String keyCodigo = codigos[i];
            int j = i - 1;

            while (j >= 0 && cantidades[j] > keyCantidad) {
                precios[j + 1] = precios[j];
                cantidades[j + 1] = cantidades[j];
                nombres[j + 1] = nombres[j];
                codigos[j + 1] = codigos[j];
                j--;
            }
            precios[j + 1] = keyPrecio;
            cantidades[j + 1] = keyCantidad;
            nombres[j + 1] = keyNombre;
            codigos[j + 1] = keyCodigo;
        }
        System.out.println("Productos ordenados por cantidad.");
    }

    public static void imprimirProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (int i = 0; i < contador; i++) {
            System.out.println(codigos[i] + " - " + nombres[i] + " - $" + precios[i] + " - " + cantidades[i] + " unidades");
        }
    }
}