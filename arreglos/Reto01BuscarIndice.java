/**
 * Reto 1 - Buscar y devolver indice (Search).
 * Dado un arreglo y un valor, devuelve el indice o -1 si no existe.
 * Complejidad: O(n) tiempo, O(1) memoria.
 */
public class Reto01BuscarIndice {

    public static int buscarIndice(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] datos = {4, 8, 15, 16, 23, 42};
        Pruebas.verificar(buscarIndice(datos, 15) == 2, "valor en el medio");
        Pruebas.verificar(buscarIndice(datos, 4) == 0, "primer elemento");
        Pruebas.verificar(buscarIndice(datos, 42) == 5, "ultimo elemento");
        Pruebas.verificar(buscarIndice(datos, 99) == -1, "valor inexistente");
        Pruebas.verificar(buscarIndice(new int[]{}, 1) == -1, "arreglo vacio");
        Pruebas.verificar(buscarIndice(new int[]{7, 7, 7}, 7) == 0, "devuelve la primera aparicion");
        System.out.println("Reto 1 OK -> buscarIndice({4, 8, 15, 16, 23, 42}, 15) = " + buscarIndice(datos, 15));
    }
}
