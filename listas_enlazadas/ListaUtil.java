/** Utilidades compartidas por los retos de listas enlazadas. */
public class ListaUtil {

    /** Crea una lista simple con los valores dados y devuelve la cabeza. */
    public static Nodo construir(int... valores) {
        Nodo cabeza = null;
        Nodo cola = null;
        for (int v : valores) {
            Nodo nodo = new Nodo(v);
            if (cabeza == null) {
                cabeza = nodo;
            } else {
                cola.siguiente = nodo;
            }
            cola = nodo;
        }
        return cabeza;
    }

    /** Devuelve la lista como texto, por ejemplo "1 -> 2 -> 3 -> null". (Solo listas sin bucle.) */
    public static String aTexto(Nodo cabeza) {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato).append(" -> ");
            actual = actual.siguiente;
        }
        sb.append("null");
        return sb.toString();
    }
}
