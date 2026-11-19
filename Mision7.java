public class Mision7 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] datos = {50, 30, 70, 20, 40, 60, 80, 10, 45};
        for (int d : datos) {
            arbol.insertar(d);
        }

        System.out.println("Lineas temporales: " + arbol.contarLineas());
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

    int contarLineas() {
        return contarRec(raiz);
    }

    int contarRec(NodoVengador nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarRec(nodo.izquierdo) + contarRec(nodo.derecho);
    }
}
