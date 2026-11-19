/** Cola (FIFO): entra por ultimoEnLaCola y sale por primeroEnLaCola. */
public class Cola {
    Nodo primeroEnLaCola;
    Nodo ultimoEnLaCola;

    public boolean estaVacia() {
        return primeroEnLaCola == null;
    }

    public void vaciar() {
        primeroEnLaCola = null;
        ultimoEnLaCola = null;
    }

    public long largo() {
        long cantidad = 0;
        Nodo actual = primeroEnLaCola;
        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }
        return cantidad;
    }

    public Object verPrimero() {
        if (primeroEnLaCola == null) return null;
        return primeroEnLaCola.contenido;
    }

    public Object verUltimo() {
        if (ultimoEnLaCola == null) return null;
        return ultimoEnLaCola.contenido;
    }

    // Insertar al final (Enfilar)
    public void enfilar(Object nuevoObjeto) {
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        if (primeroEnLaCola == null) {
            primeroEnLaCola = nuevoNodo;
        } else {
            ultimoEnLaCola.siguiente = nuevoNodo;
        }
        ultimoEnLaCola = nuevoNodo;
    }

    // Atender / eliminar del principio (Desenfilar)
    public Object sacar() {
        if (primeroEnLaCola == null) return null;
        Object dato = primeroEnLaCola.contenido;
        primeroEnLaCola = primeroEnLaCola.siguiente;
        if (primeroEnLaCola == null) ultimoEnLaCola = null; // si quedo vacia
        return dato;
    }
}
