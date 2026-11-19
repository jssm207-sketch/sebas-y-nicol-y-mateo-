public class Mision8 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] datos = {50, 30, 70, 20, 40, 60, 80, 10, 45};
        for (int d : datos) {
            arbol.insertar(d);
        }

        System.out.println("Menor: " + arbol.encontrarMenor());
        System.out.println("Mayor: " + arbol.encontrarMayor());
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

    int encontrarMenor() {
        NodoVengador actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual.dato;
    }

    int encontrarMayor() {
        NodoVengador actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.dato;
    }
}
