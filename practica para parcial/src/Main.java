public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos
        inventario.agregarProducto(new Producto("A101", "Laptop Lenovo", 5, 2500.0));
        inventario.agregarProducto(new Producto("B202", "Mouse Logitech", 15, 30.0));
        inventario.agregarProducto(new Producto("C303", "Teclado Mecánico", 8, 80.0));

        // Mostrar inventario
        System.out.println("\nInventario Actual:");
        inventario.mostrarInventario();

        // Buscar producto
        System.out.println("\nBuscando producto B202:");
        inventario.buscarProducto("B202");

        // Eliminar producto
        System.out.println("\nEliminando producto C303:");
        inventario.eliminarProducto("C303");

        // Mostrar inventario actualizado
        System.out.println("\nInventario después de eliminación:");
        inventario.mostrarInventario();

        // Agregar devoluciones y reposiciones
        inventario.agregarDevolucion(new Producto("B202", "Mouse Logitech", 1, 30.0));
        inventario.agregarReposicion(new Producto("C303", "Teclado Mecánico", 5, 80.0));

        // Procesar devolución y reposición
        System.out.println("\nProcesando devolución:");
        inventario.procesarDevolucion();

        System.out.println("\nProcesando reposición:");
        inventario.procesarReposicion();
    }
}
