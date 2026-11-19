import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Utilidades minimas para verificar resultados en los desafios. */
public class Pruebas {

    public static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError("Fallo la prueba: " + mensaje);
        }
    }

    /** Ejecuta una accion y devuelve todo lo que imprimio por consola. */
    public static String capturarSalida(Runnable accion) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            accion.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }

    /** Vacia la cola y la devuelve como texto, del primero al ultimo: "1,2,3". */
    public static String colaATexto(Cola cola) {
        StringBuilder sb = new StringBuilder();
        while (!cola.estaVacia()) {
            if (sb.length() > 0) sb.append(",");
            sb.append(cola.sacar());
        }
        return sb.toString();
    }

    /** Vacia la pila y la devuelve como texto, de la cima hacia el fondo: "3,2,1". */
    public static String pilaATexto(Pila pila) {
        StringBuilder sb = new StringBuilder();
        while (!pila.estaVacia()) {
            if (sb.length() > 0) sb.append(",");
            sb.append(pila.sacar());
        }
        return sb.toString();
    }
}
