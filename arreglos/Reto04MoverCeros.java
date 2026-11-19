import java.util.Arrays;

/**
 * Reto 4 - Mover ceros al final.
 * [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0]
 * Se usa un puntero idxNoCero: primero se copian los elementos distintos
 * de 0 al inicio (conservando su orden) y luego se rellena el resto con ceros.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto04MoverCeros {

    public static void moverCeros(int[] arreglo) {
        int idxNoCero = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                arreglo[idxNoCero] = arreglo[i];
                idxNoCero++;
            }
        }
        for (int i = idxNoCero; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moverCeros(a);
        Pruebas.verificar(Arrays.equals(a, new int[]{1, 3, 12, 0, 0}), "ejemplo de la clase");

        int[] b = {0, 0, 0};
        moverCeros(b);
        Pruebas.verificar(Arrays.equals(b, new int[]{0, 0, 0}), "todos ceros");

        int[] c = {1, 2, 3};
        moverCeros(c);
        Pruebas.verificar(Arrays.equals(c, new int[]{1, 2, 3}), "sin ceros");

        int[] d = {};
        moverCeros(d);
        Pruebas.verificar(d.length == 0, "arreglo vacio");

        int[] e = {4, 0, 5, 0, 0, 6};
        moverCeros(e);
        Pruebas.verificar(Arrays.equals(e, new int[]{4, 5, 6, 0, 0, 0}), "ceros intercalados");
        System.out.println("Reto 4 OK -> {0, 1, 0, 3, 12} = " + Arrays.toString(a));
    }
}
