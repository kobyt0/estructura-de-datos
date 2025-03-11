class ListaEnlazada {
    private class Nodo {
        Producto producto;
        Nodo siguiente;

        public Nodo(Producto producto) {
            this.producto = producto;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    // Agregar producto a la lista
    public void agregarProducto(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Eliminar producto por código
    public boolean eliminarProducto(String codigo) {
        if (cabeza == null) return false;
        if (cabeza.producto.getCodigo().equals(codigo)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.producto.getCodigo().equals(codigo)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Buscar producto por código (búsqueda lineal)
    public Producto buscarProducto(String codigo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.producto.getCodigo().equals(codigo)) {
                return actual.producto;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Mostrar inventario
    public void mostrarInventario() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }
}

