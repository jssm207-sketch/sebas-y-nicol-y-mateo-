/**
 * Desafio 4 - El Arsenal de Drax (busqueda segura en una pila).
 * Saca el arma buscada de la pila conservando el orden exacto de las demas.
 * Devuelve el arma, o null si no esta (en ese caso la pila queda intacta).
 */
public class Desafio04ArsenalDrax {

    public static String buscarYExtraer(Pila armas, String objetivo) {
        if (objetivo == null) return null;
        Pila auxiliar = new Pila();
        String encontrada = null;

        while (!armas.estaVacia()) {
            Object arma = armas.sacar();
            if (objetivo.equals(arma)) {
                encontrada = (String) arma;
                break;                      // se detiene la busqueda
            }
            auxiliar.apilar(arma);          // guardar las que no son
        }

        // Regresar las armas guardadas, con el orden original
        while (!auxiliar.estaVacia()) {
            armas.apilar(auxiliar.sacar());
        }
        return encontrada;
    }

    private static Pila crearArsenal() {
        Pila armas = new Pila();            // de fondo a cima
        armas.apilar("Pistola");
        armas.apilar("Rifle");
        armas.apilar("Dagas de Vibranium");
        armas.apilar("Escudo");
        armas.apilar("Hacha");
        return armas;
    }

    public static void main(String[] args) {
        // Arma en el medio
        Pila armas = crearArsenal();
        String extraida = buscarYExtraer(armas, "Dagas de Vibranium");
        Pruebas.verificar("Dagas de Vibranium".equals(extraida), "devuelve las Dagas de Vibranium");
        Pruebas.verificar(Pruebas.pilaATexto(armas).equals("Hacha,Escudo,Rifle,Pistola"),
                "el resto conserva el orden original");

        // Arma en la cima
        armas = crearArsenal();
        Pruebas.verificar("Hacha".equals(buscarYExtraer(armas, "Hacha")), "arma en la cima");
        Pruebas.verificar(Pruebas.pilaATexto(armas).equals("Escudo,Dagas de Vibranium,Rifle,Pistola"),
                "orden correcto tras sacar la cima");

        // Arma en el fondo
        armas = crearArsenal();
        Pruebas.verificar("Pistola".equals(buscarYExtraer(armas, "Pistola")), "arma en el fondo");
        Pruebas.verificar(Pruebas.pilaATexto(armas).equals("Hacha,Escudo,Dagas de Vibranium,Rifle"),
                "orden correcto tras sacar el fondo");

        // Arma inexistente: la pila queda intacta
        armas = crearArsenal();
        Pruebas.verificar(buscarYExtraer(armas, "Lanza") == null, "arma inexistente devuelve null");
        Pruebas.verificar(armas.largo() == 5, "no se pierde ninguna arma");
        Pruebas.verificar(Pruebas.pilaATexto(armas).equals("Hacha,Escudo,Dagas de Vibranium,Rifle,Pistola"),
                "la pila queda exactamente igual");

        // Pila vacia
        Pruebas.verificar(buscarYExtraer(new Pila(), "Hacha") == null, "pila vacia devuelve null");
        System.out.println("Desafio 4 OK -> extrae las Dagas de Vibranium sin alterar el resto");
    }
}
