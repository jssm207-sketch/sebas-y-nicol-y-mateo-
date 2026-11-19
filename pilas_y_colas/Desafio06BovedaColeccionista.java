import java.util.Arrays;
import java.util.Random;

/**
 * Desafio 6 - La Boveda del Coleccionista (ordenar una pila).
 * Deja la gema de mayor poder en la cima. Restriccion: una sola pila
 * auxiliar y variables numericas simples (sin arreglos, listas, colas ni
 * recursividad en la solucion).
 *
 * Idea: la pila auxiliar se mantiene con el MENOR arriba. Para cada gema
 * "temp" se devuelven a la original las gemas de la auxiliar menores que
 * temp, se apila temp y se continua. Al terminar, la auxiliar tiene el
 * menor arriba; pasarla de vuelta a la original invierte el orden y deja
 * el mayor en la cima.
 */
public class Desafio06BovedaColeccionista {

    public static void ordenarPila(Pila gemas) {
        Pila auxiliar = new Pila();
        while (!gemas.estaVacia()) {
            int temp = (int) gemas.sacar();
            while (!auxiliar.estaVacia() && (int) auxiliar.verPrimero() < temp) {
                gemas.apilar(auxiliar.sacar());
            }
            auxiliar.apilar(temp);
        }
        while (!auxiliar.estaVacia()) {
            gemas.apilar(auxiliar.sacar());
        }
    }

    public static void main(String[] args) {
        Pila gemas = new Pila();
        int[] poderes = {34, 3, 31, 98, 92, 23};
        for (int p : poderes) gemas.apilar(p);
        ordenarPila(gemas);
        Pruebas.verificar(gemas.verPrimero().equals(98), "la gema de mayor poder queda en la cima");
        Pruebas.verificar(Pruebas.pilaATexto(gemas).equals("98,92,34,31,23,3"), "orden descendente de cima a fondo");

        // Casos borde
        Pila vacia = new Pila();
        ordenarPila(vacia);
        Pruebas.verificar(vacia.estaVacia(), "pila vacia");

        Pila una = new Pila();
        una.apilar(7);
        ordenarPila(una);
        Pruebas.verificar(Pruebas.pilaATexto(una).equals("7"), "una sola gema");

        Pila repetidas = new Pila();
        for (int p : new int[]{5, 1, 5, 3, 1}) repetidas.apilar(p);
        ordenarPila(repetidas);
        Pruebas.verificar(Pruebas.pilaATexto(repetidas).equals("5,5,3,1,1"), "gemas con poder repetido");

        Pila yaOrdenada = new Pila();
        for (int p : new int[]{1, 2, 3, 4}) yaOrdenada.apilar(p);   // cima = 4
        ordenarPila(yaOrdenada);
        Pruebas.verificar(Pruebas.pilaATexto(yaOrdenada).equals("4,3,2,1"), "ya ordenada");

        Pila alReves = new Pila();
        for (int p : new int[]{4, 3, 2, 1}) alReves.apilar(p);      // cima = 1
        ordenarPila(alReves);
        Pruebas.verificar(Pruebas.pilaATexto(alReves).equals("4,3,2,1"), "ordenada al reves");

        // Prueba aleatoria contra Arrays.sort (solo en las pruebas, no en la solucion)
        Random azar = new Random(2026);
        for (int ronda = 0; ronda < 200; ronda++) {
            int n = azar.nextInt(30);
            int[] valores = new int[n];
            Pila pila = new Pila();
            for (int i = 0; i < n; i++) {
                valores[i] = azar.nextInt(50);
                pila.apilar(valores[i]);
            }
            ordenarPila(pila);
            Arrays.sort(valores);
            StringBuilder esperado = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                if (esperado.length() > 0) esperado.append(",");
                esperado.append(valores[i]);
            }
            Pruebas.verificar(Pruebas.pilaATexto(pila).equals(esperado.toString()),
                    "pila aleatoria " + ronda + " ordenada correctamente");
        }
        System.out.println("Desafio 6 OK -> {34, 3, 31, 98, 92, 23} ordenada, mayor en la cima = 98");
    }
}
