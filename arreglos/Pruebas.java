/** Utilidad minima para verificar resultados en los retos. */
public class Pruebas {
    public static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError("Fallo la prueba: " + mensaje);
        }
    }
}
