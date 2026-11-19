/**
 * Reto 2 - Invertir lista (pregunta de entrevista).
 * A->B->null se convierte en B->A->null. Se usan 3 punteros
 * (prev, actual, sig) y se voltea la flecha de cada nodo.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto02InvertirLista {

    public static Nodo invertirLista(Nodo cabeza) {
        Nodo prev = null;
        Nodo actual = cabeza;
        Nodo sig = null;
        while (actual != null) {
            sig = actual.siguiente;     // guardar el siguiente
            actual.siguiente = prev;    // invertir la flecha
            prev = actual;              // avanzar prev
            actual = sig;               // avanzar actual
        }
        return prev;                    // prev es la nueva cabeza
    }

    public static void main(String[] args) {
        Nodo invertida = invertirLista(ListaUtil.construir(1, 2, 3, 4, 5));
        Pruebas.verificar(ListaUtil.aTexto(invertida).equals("5 -> 4 -> 3 -> 2 -> 1 -> null"), "lista de 5");
        Pruebas.verificar(ListaUtil.aTexto(invertirLista(ListaUtil.construir(1, 2))).equals("2 -> 1 -> null"), "lista de 2");
        Pruebas.verificar(ListaUtil.aTexto(invertirLista(ListaUtil.construir(7))).equals("7 -> null"), "un solo nodo");
        Pruebas.verificar(invertirLista(null) == null, "lista vacia");
        System.out.println("Reto 2 OK -> {1, 2, 3, 4, 5} invertida = " + ListaUtil.aTexto(invertida));
    }
}
