import java.util.Arrays;

public class OrdenamientosObjetos {

    public static void main(String[] args) {
        String[] nombres = {"Laptop", "Mouse", "Teclado", "Monitor", "Auriculares",
                "Impresora", "Memoria USB", "Disco Duro", "Tarjeta Gráfica", "Tablet"};

        double[] precios = {1200.99, 25.50, 45.75, 300.99, 99.99,
                150.00, 15.00, 80.50, 400.00, 250.00};

        System.out.println("Productos antes de ordenar:");
        imprimirProductos(nombres, precios);

        // Ordenar con Burbuja
        burbuja(nombres, precios);
        System.out.println("\nOrdenado con Burbuja:");
        imprimirProductos(nombres, precios);

        // Restaurar los valores originales
        nombres = new String[]{"Laptop", "Mouse", "Teclado", "Monitor", "Auriculares",
                "Impresora", "Memoria USB", "Disco Duro", "Tarjeta Gráfica", "Tablet"};

        precios = new double[]{1200.99, 25.50, 45.75, 300.99, 99.99,
                150.00, 15.00, 80.50, 400.00, 250.00};

        // Ordenar con Insertion Sort
        insertSort(nombres, precios);
        System.out.println("\nOrdenado con Insertion Sort:");
        imprimirProductos(nombres, precios);
    }

    public static void burbuja(String[] nombres, double[] precios) {
        int n = precios.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (precios[j] > precios[j + 1]) {
                    double tempPrecio = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = tempPrecio;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;
                }
            }
        }
    }

    public static void insertSort(String[] nombres, double[] precios) {
        int len = precios.length;

        for (int i = 1; i < len; i++) {
            double keyPrecio = precios[i];
            String keyNombre = nombres[i];
            int j = i - 1;

            while (j >= 0 && keyPrecio < precios[j]) {
                precios[j + 1] = precios[j];
                nombres[j + 1] = nombres[j];
                j--;
            }
            precios[j + 1] = keyPrecio;
            nombres[j + 1] = keyNombre;
        }
    }

    public static void imprimirProductos(String[] nombres, double[] precios) {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " ($" + precios[i] + ")");
        }
    }
}