/** Eslabon basico: guarda un dato (contenido) y un puntero al siguiente nodo. */
public class Nodo {
    Object contenido;
    Nodo siguiente;

    public Nodo(Object contenido) {
        this.contenido = contenido;
        this.siguiente = null;
    }
}
