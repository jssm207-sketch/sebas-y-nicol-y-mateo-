/**
 * Reto 1 - InsertAtEnd (insertar al final).
 * Si la cabeza es null, el nuevo nodo es la cabeza. Si no, se recorre hasta
 * el ultimo nodo (actual.siguiente == null) y se enlaza el nuevo nodo.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto01InsertAtEnd {

    public static Nodo insertAtEnd(Nodo cabeza, int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            return nuevo;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        return cabeza;
    }

    public static void main(String[] args) {
        Nodo cabeza = null;
        cabeza = insertAtEnd(cabeza, 1);
        Pruebas.verificar(ListaUtil.aTexto(cabeza).equals("1 -> null"), "insertar en lista vacia");
        cabeza = insertAtEnd(cabeza, 2);
        cabeza = insertAtEnd(cabeza, 3);
        Pruebas.verificar(ListaUtil.aTexto(cabeza).equals("1 -> 2 -> 3 -> null"), "insertar varios");

        Nodo otra = ListaUtil.construir(10, 20);
        otra = insertAtEnd(otra, 30);
        Pruebas.verificar(ListaUtil.aTexto(otra).equals("10 -> 20 -> 30 -> null"), "insertar en lista existente");
        System.out.println("Reto 1 OK -> lista = " + ListaUtil.aTexto(cabeza));
    }
}
