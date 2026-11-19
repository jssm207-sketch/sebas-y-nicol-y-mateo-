/**
 * Desafio 1 - El Cargador de Rocket (Pila con capacidad maxima).
 * La clase PilaLimitada esta en PilaLimitada.java; aqui se prueba.
 */
public class Desafio01CargadorRocket {

    public static void main(String[] args) {
        PilaLimitada cargador = new PilaLimitada(5);
        for (int i = 1; i <= 5; i++) {
            cargador.apilar("Bateria " + i);
        }
        Pruebas.verificar(cargador.largo() == 5, "el cargador queda con 5 baterias");

        // La sexta bateria debe rechazarse con un mensaje de error
        String salida = Pruebas.capturarSalida(() -> cargador.apilar("Bateria 6"));
        Pruebas.verificar(salida.contains("ERROR"), "muestra mensaje de error al exceder el limite");
        Pruebas.verificar(cargador.largo() == 5, "la sexta bateria no se apila");
        Pruebas.verificar(cargador.verPrimero().equals("Bateria 5"), "la cima sigue siendo la Bateria 5");

        // Al sacar se libera espacio
        Pruebas.verificar(cargador.sacar().equals("Bateria 5"), "sacar devuelve la cima (LIFO)");
        Pruebas.verificar(cargador.largo() == 4, "cantidadActual baja al sacar");
        cargador.apilar("Bateria 6");
        Pruebas.verificar(cargador.verPrimero().equals("Bateria 6"), "ahora si cabe la Bateria 6");
        Pruebas.verificar(cargador.largo() == 5, "vuelve a quedar lleno");

        // Vaciar completamente
        for (int i = 0; i < 5; i++) cargador.sacar();
        Pruebas.verificar(cargador.estaVacia() && cargador.largo() == 0, "queda vacia");
        Pruebas.verificar(cargador.sacar() == null, "sacar en pila vacia devuelve null");
        System.out.println("Desafio 1 OK -> PilaLimitada(5) rechaza la sexta bateria");
    }
}
