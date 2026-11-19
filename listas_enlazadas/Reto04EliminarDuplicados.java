/**
 * Reto 4 - Eliminar duplicados (lista ordenada).
 * 1->1->2->3->3 se convierte en 1->2->3.
 * Si actual.dato == actual.siguiente.dato se salta el nodo repetido; si no,
 * se avanza. No usa buffer extra.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto04EliminarDuplicados {

    public static Nodo eliminarDuplicados(Nodo cabeza) {
        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.dato == actual.siguiente.dato) {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
        return cabeza;
    }

    public static void main(String[] args) {
        Nodo resultado = eliminarDuplicados(ListaUtil.construir(1, 1, 2, 3, 3));
        Pruebas.verificar(ListaUtil.aTexto(resultado).equals("1 -> 2 -> 3 -> null"), "ejemplo de la clase");
        Pruebas.verificar(ListaUtil.aTexto(eliminarDuplicados(ListaUtil.construir(1, 1, 1, 1))).equals("1 -> null"), "todos iguales");
        Pruebas.verificar(ListaUtil.aTexto(eliminarDuplicados(ListaUtil.construir(1, 2, 3))).equals("1 -> 2 -> 3 -> null"), "sin duplicados");
        Pruebas.verificar(ListaUtil.aTexto(eliminarDuplicados(ListaUtil.construir(5))).equals("5 -> null"), "un solo nodo");
        Pruebas.verificar(eliminarDuplicados(null) == null, "lista vacia");
        System.out.println("Reto 4 OK -> {1, 1, 2, 3, 3} = " + ListaUtil.aTexto(resultado));
    }
}
