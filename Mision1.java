public class Mision1 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.crearYggdrasil();
        arbol.mostrar();
    }
}

class NodoVengador {
    String dato;
    NodoVengador izquierdo;
    NodoVengador derecho;

    NodoVengador(String dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinario {
    NodoVengador raiz;

    void crearYggdrasil() {
        raiz = new NodoVengador("Asgard");
        raiz.izquierdo = new NodoVengador("Midgard");
        raiz.derecho = new NodoVengador("Vanaheim");
    }

    void mostrar() {
        System.out.println("Raiz: " + raiz.dato);
        System.out.println("Izquierdo: " + raiz.izquierdo.dato);
        System.out.println("Derecho: " + raiz.derecho.dato);
    }
}
