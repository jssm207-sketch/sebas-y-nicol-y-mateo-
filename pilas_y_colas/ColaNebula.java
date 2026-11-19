/**
 * Cola implementada SOLO con dos pilas (sin nodos ni punteros directos).
 *  - enfilar: apila en pilaEntrada, O(1).
 *  - sacar: si pilaSalida esta vacia, traspasa TODO de pilaEntrada a
 *    pilaSalida (esto invierte el orden y deja el mas antiguo arriba).
 */
public class ColaNebula {
    Pila pilaEntrada = new Pila();
    Pila pilaSalida = new Pila();

    public void enfilar(Object nuevoObjeto) {
        pilaEntrada.apilar(nuevoObjeto);
    }

    public Object sacar() {
        if (pilaSalida.estaVacia()) {
            while (!pilaEntrada.estaVacia()) {
                pilaSalida.apilar(pilaEntrada.sacar());
            }
        }
        return pilaSalida.sacar();      // null si ambas estaban vacias
    }

    public boolean estaVacia() {
        return pilaEntrada.estaVacia() && pilaSalida.estaVacia();
    }

    public long largo() {
        return pilaEntrada.largo() + pilaSalida.largo();
    }
}
