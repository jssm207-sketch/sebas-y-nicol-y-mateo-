/**
 * Reto 3 - Devolver el nodo N desde el final.
 * Se usan dos punteros (rapido y lento) sin conocer el tamano de la lista:
 * el rapido avanza N pasos primero y luego ambos avanzan de a 1 hasta que
 * el rapido llega a null. El lento queda en el nodo buscado.
 * n = 1 es el ultimo nodo. Devuelve null si N es invalido o mayor al tamano.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto03NodoDesdeElFinal {

    public static Nodo nodoDesdeElFinal(Nodo cabeza, int n) {
        if (n <= 0) {
            return null;
        }
        Nodo rapido = cabeza;
        Nodo lento = cabeza;
        for (int i = 0; i < n; i++) {
            if (rapido == null) {
                return null;            // la lista tiene menos de N nodos
            }
            rapido = rapido.siguiente;
        }
        while (rapido != null) {
            rapido = rapido.siguiente;
            lento = lento.siguiente;
        }
        return lento;
    }

    public static void main(String[] args) {
        Nodo cabeza = ListaUtil.construir(1, 2, 3, 4, 5);
        Pruebas.verificar(nodoDesdeElFinal(cabeza, 1).dato == 5, "1 desde el final = ultimo");
        Pruebas.verificar(nodoDesdeElFinal(cabeza, 2).dato == 4, "2 desde el final");
        Pruebas.verificar(nodoDesdeElFinal(cabeza, 5).dato == 1, "5 desde el final = primero");
        Pruebas.verificar(nodoDesdeElFinal(cabeza, 6) == null, "N mayor al tamano");
        Pruebas.verificar(nodoDesdeElFinal(cabeza, 0) == null, "N = 0");
        Pruebas.verificar(nodoDesdeElFinal(null, 1) == null, "lista vacia");
        System.out.println("Reto 3 OK -> el 2do desde el final de {1, 2, 3, 4, 5} es " + nodoDesdeElFinal(cabeza, 2).dato);
    }
}
