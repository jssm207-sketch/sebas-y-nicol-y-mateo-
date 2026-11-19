/**
 * Reto 5 - Encontrar el numero faltante.
 * El arreglo contiene los numeros de 1 a N con uno faltante (N = longitud + 1).
 * Suma ideal = N * (N + 1) / 2; el faltante es suma ideal - suma real.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto05NumeroFaltante {

    public static int numeroFaltante(int[] arreglo) {
        int n = arreglo.length + 1;
        int sumaIdeal = n * (n + 1) / 2;
        int sumaReal = 0;
        for (int i = 0; i < arreglo.length; i++) {
            sumaReal += arreglo[i];
        }
        return sumaIdeal - sumaReal;
    }

    public static void main(String[] args) {
        Pruebas.verificar(numeroFaltante(new int[]{1, 2, 4, 5}) == 3, "falta uno del medio");
        Pruebas.verificar(numeroFaltante(new int[]{2, 3, 4, 5}) == 1, "falta el primero");
        Pruebas.verificar(numeroFaltante(new int[]{1, 2, 3, 4}) == 5, "falta el ultimo");
        Pruebas.verificar(numeroFaltante(new int[]{3, 1, 5, 2}) == 4, "arreglo desordenado");
        Pruebas.verificar(numeroFaltante(new int[]{}) == 1, "N = 1");
        Pruebas.verificar(numeroFaltante(new int[]{1}) == 2, "N = 2");
        System.out.println("Reto 5 OK -> numeroFaltante({1, 2, 4, 5}) = " + numeroFaltante(new int[]{1, 2, 4, 5}));
    }
}
