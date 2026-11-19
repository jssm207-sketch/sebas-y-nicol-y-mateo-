/**
 * Pila con capacidad maxima. Si se intenta apilar mas elementos de los
 * permitidos, se muestra un mensaje de error y el elemento NO se apila.
 */
public class PilaLimitada {
    Nodo primeroDeLaPila;
    int capacidadMaxima;
    int cantidadActual;

    public PilaLimitada(int max) {
        this.capacidadMaxima = max;
        this.cantidadActual = 0;
    }

    public void apilar(Object nuevoObjeto) {
        if (cantidadActual >= capacidadMaxima) {
            System.out.println("ERROR: cargador lleno (maximo " + capacidadMaxima
                    + "). No se puede apilar: " + nuevoObjeto);
            return;
        }
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        nuevoNodo.siguiente = primeroDeLaPila;
        primeroDeLaPila = nuevoNodo;
        cantidadActual++;
    }

    public Object sacar() {
        if (primeroDeLaPila == null) return null;
        Object dato = primeroDeLaPila.contenido;
        primeroDeLaPila = primeroDeLaPila.siguiente;
        cantidadActual--;
        return dato;
    }

    public Object verPrimero() {
        if (primeroDeLaPila == null) return null;
        return primeroDeLaPila.contenido;
    }

    public boolean estaVacia() {
        return primeroDeLaPila == null;
    }

    public long largo() {
        return cantidadActual;
    }
}
