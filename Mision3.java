public class Mision3 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] datos = {50, 30, 70, 20, 40, 60, 80, 10, 45};
        for (int d : datos) {
            arbol.insertar(d);
        }

        System.out.println("Buscar 60: " + arbol.buscar(60));
        System.out.println("Buscar 99: " + arbol.buscar(99));
    }
}

class NodoVengador {
    int dato;
    NodoVengador izquierdo;
    NodoVengador derecho;

    NodoVengador(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinario {
    NodoVengador raiz;

    void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    NodoVengador insertarRec(NodoVengador nodo, int dato) {
        if (nodo == null) {
            return new NodoVengador(dato);
        }
        if (dato < nodo.dato) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertarRec(nodo.derecho, dato);
        }
        return nodo;
    }

    boolean buscar(int amenaza) {
        return buscarRec(raiz, amenaza);
    }

    boolean buscarRec(NodoVengador nodo, int amenaza) {
        if (nodo == null) {
            return false;
        }
        if (amenaza == nodo.dato) {
            return true;
        }
        if (amenaza < nodo.dato) {
            return buscarRec(nodo.izquierdo, amenaza);
        } else {
            return buscarRec(nodo.derecho, amenaza);
        }
    }
}
