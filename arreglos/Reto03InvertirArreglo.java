import java.util.Arrays;

/**
 * Reto 3 - Invertir arreglo in situ (Reverse).
 * Invierte los valores sin crear un nuevo arreglo, usando dos punteros
 * (inicio y fin) que se acercan intercambiando con una variable temporal.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto03InvertirArreglo {

    public static void invertirArreglo(int[] arreglo) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        while (inicio < fin) {
            int temp = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = temp;
            inicio++;
            fin--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] mismaReferencia = a;
        invertirArreglo(a);
        Pruebas.verificar(Arrays.equals(a, new int[]{5, 4, 3, 2, 1}), "longitud impar");
        Pruebas.verificar(a == mismaReferencia, "se modifica el mismo arreglo (in situ)");

        int[] b = {1, 2, 3, 4};
        invertirArreglo(b);
        Pruebas.verificar(Arrays.equals(b, new int[]{4, 3, 2, 1}), "longitud par");

        int[] c = {};
        invertirArreglo(c);
        Pruebas.verificar(c.length == 0, "arreglo vacio");

        int[] d = {9};
        invertirArreglo(d);
        Pruebas.verificar(Arrays.equals(d, new int[]{9}), "un solo elemento");
        System.out.println("Reto 3 OK -> {1, 2, 3, 4, 5} invertido = " + Arrays.toString(a));
    }
}
