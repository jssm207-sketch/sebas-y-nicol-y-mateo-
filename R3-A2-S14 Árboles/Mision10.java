public class Mision10 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] datos = {50, 30, 70, 20, 40, 60, 80, 10, 45};
        for (int d : datos) {
            arbol.insertar(d);
        }

        System.out.print("Original: ");
        arbol.inOrden(arbol.raiz);
        System.out.println();

        arbol.eliminar(10);   // hoja
        System.out.print("Sin 10:   ");
        arbol.inOrden(arbol.raiz);
        System.out.println();

        arbol.eliminar(40);   // un hijo
        System.out.print("Sin 40:   ");
        arbol.inOrden(arbol.raiz);
        System.out.println();

        arbol.eliminar(50);   // dos hijos
        System.out.print("Sin 50:   ");
        arbol.inOrden(arbol.raiz);
        System.out.println();
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

    void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    NodoVengador eliminarRec(NodoVengador nodo, int dato) {
        if (nodo == null) {
            return null;
        }
        if (dato < nodo.dato) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = eliminarRec(nodo.derecho, dato);
        } else {
            // caso 1: sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            // caso 2: un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // caso 3: dos hijos (sucesor inorden)
            NodoVengador sucesor = nodo.derecho;
            while (sucesor.izquierdo != null) {
                sucesor = sucesor.izquierdo;
            }
            nodo.dato = sucesor.dato;
            nodo.derecho = eliminarRec(nodo.derecho, sucesor.dato);
        }
        return nodo;
    }

    void inOrden(NodoVengador nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecho);
        }
    }
}
