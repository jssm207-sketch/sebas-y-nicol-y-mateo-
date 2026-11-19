/**
 * Reto 5 - Detectar bucle (Liebre y Tortuga, algoritmo de Floyd).
 * El lento avanza 1 paso y el rapido 2. Si en algun momento coinciden
 * (lento == rapido) hay un bucle; si el rapido llega a null, no lo hay.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto05DetectarBucle {

    public static boolean detectarBucle(Nodo cabeza) {
        Nodo lento = cabeza;
        Nodo rapido = cabeza;
        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
            if (lento == rapido) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Listas sin bucle
        Pruebas.verificar(!detectarBucle(ListaUtil.construir(1, 2, 3, 4)), "lista normal");
        Pruebas.verificar(!detectarBucle(null), "lista vacia");
        Pruebas.verificar(!detectarBucle(ListaUtil.construir(1)), "un solo nodo sin bucle");

        // Lista con bucle: 1->2->3->4->(vuelve al 2)
        Nodo conBucle = ListaUtil.construir(1, 2, 3, 4);
        Nodo cola = conBucle;
        while (cola.siguiente != null) {
            cola = cola.siguiente;
        }
        cola.siguiente = conBucle.siguiente;
        Pruebas.verificar(detectarBucle(conBucle), "bucle hacia el segundo nodo");

        // Un solo nodo apuntando a si mismo
        Nodo unico = ListaUtil.construir(9);
        unico.siguiente = unico;
        Pruebas.verificar(detectarBucle(unico), "nodo apuntando a si mismo");
        System.out.println("Reto 5 OK -> detecta bucles correctamente");
    }
}
