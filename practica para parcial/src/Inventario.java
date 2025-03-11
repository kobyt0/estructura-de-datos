import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Inventario {
    private ListaEnlazada productos = new ListaEnlazada();
    private Stack<Producto> devoluciones = new Stack<>();
    private Queue<Producto> reposiciones = new LinkedList<>();

    public void agregarProducto(Producto p) {
        productos.agregarProducto(p);
    }

    public void eliminarProducto(String codigo) {
        if (productos.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado: " + codigo);
        } else {
            System.out.println("No se encontró el producto.");
        }
    }

    public void buscarProducto(String codigo) {
        Producto p = productos.buscarProducto(codigo);
        if (p != null) {
            System.out.println("Producto encontrado: " + p);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarDevolucion(Producto p) {
        devoluciones.push(p);
    }

    public void procesarDevolucion() {
        if (!devoluciones.isEmpty()) {
            Producto devuelto = devoluciones.pop();
            System.out.println("Procesando devolución: " + devuelto);
        } else {
            System.out.println("No hay devoluciones pendientes.");
        }
    }

    public void agregarReposicion(Producto p) {
        reposiciones.offer(p);
    }

    public void procesarReposicion() {
        if (!reposiciones.isEmpty()) {
            Producto repuesto = reposiciones.poll();
            System.out.println("Reposición realizada: " + repuesto);
        } else {
            System.out.println("No hay reposiciones pendientes.");
        }
    }

    public void mostrarInventario() {
        productos.mostrarInventario();
    }
}
