/** Pila (LIFO): todo entra y sale por un solo extremo, primeroDeLaPila. */
public class Pila {
    Nodo primeroDeLaPila;

    public boolean estaVacia() {
        return primeroDeLaPila == null;
    }

    public void vaciar() {
        primeroDeLaPila = null;
    }

    public long largo() {
        long cantidad = 0;
        Nodo actual = primeroDeLaPila;
        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }
        return cantidad;
    }

    public Object verPrimero() {
        if (primeroDeLaPila == null) return null;
        return primeroDeLaPila.contenido;
    }

    // Apilar (Push)
    public void apilar(Object nuevoObjeto) {
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        nuevoNodo.siguiente = primeroDeLaPila;
        primeroDeLaPila = nuevoNodo;
    }

    // Sacar (Pop): elimina el primer nodo y devuelve su contenido (null si esta vacia)
    public Object sacar() {
        if (primeroDeLaPila == null) return null;
        Object dato = primeroDeLaPila.contenido;
        primeroDeLaPila = primeroDeLaPila.siguiente;
        return dato;
    }

    public Object sacarYverPrimero() {
        return sacar();
    }
}
