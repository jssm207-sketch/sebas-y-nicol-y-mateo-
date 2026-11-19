/**
 * Reto 2 - Suma total de elementos.
 * Acumula todos los valores numericos del arreglo.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto02SumaTotal {

    public static int sumaTotal(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma;
    }

    public static void main(String[] args) {
        Pruebas.verificar(sumaTotal(new int[]{1, 2, 3, 4, 5}) == 15, "suma basica");
        Pruebas.verificar(sumaTotal(new int[]{}) == 0, "arreglo vacio");
        Pruebas.verificar(sumaTotal(new int[]{-5, 5}) == 0, "negativos y positivos");
        Pruebas.verificar(sumaTotal(new int[]{10}) == 10, "un solo elemento");
        System.out.println("Reto 2 OK -> sumaTotal({1, 2, 3, 4, 5}) = " + sumaTotal(new int[]{1, 2, 3, 4, 5}));
    }
}
