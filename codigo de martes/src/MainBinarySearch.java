public class MainBinarySearch {

    public static void main(String[] args) {

        int[] testArray = {1, 5, 8, 9, 12, 24, 50, 54, 88, 120, 200, 201, 1128};

        int objetivo = 50;


        int resultadoIterativo = busquedaBinariaIterativa(testArray, objetivo);
        System.out.println("Búsqueda iterativa: " + (resultadoIterativo != -1 ?
                "Elemento encontrado en el índice " + resultadoIterativo : "Elemento no encontrado"));

        
        int resultadoRecursivo = busquedaBinariaRecursiva(testArray, objetivo, 0, testArray.length - 1);
        System.out.println("Búsqueda recursiva: " + (resultadoRecursivo != -1 ?
                "Elemento encontrado en el índice " + resultadoRecursivo : "Elemento no encontrado"));
    }

    public static int busquedaBinariaIterativa(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == objetivo) {
                return medio;
            }

            if (arr[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }

    public static int busquedaBinariaRecursiva(int[] arr, int objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        if (arr[medio] == objetivo) {
            return medio;
        }

        if (arr[medio] > objetivo) {
            return busquedaBinariaRecursiva(arr, objetivo, izquierda, medio - 1);
        }

        return busquedaBinariaRecursiva(arr, objetivo, medio + 1, derecha);
    }
}