/**
 * Desafio 2 - El Walkman de Star-Lord (Cola ciclica basica).
 * reproducirSiguiente saca la cancion del frente, la "reproduce" y la
 * vuelve a enfilar al final, asi la playlist nunca se acaba (loop).
 */
public class Desafio02WalkmanStarLord {

    public static Object reproducirSiguiente(Cola playlist) {
        Object cancion = playlist.sacar();
        if (cancion == null) {
            System.out.println("La playlist esta vacia, no hay nada que reproducir.");
            return null;
        }
        System.out.println("Reproduciendo: " + cancion);
        playlist.enfilar(cancion);   // para que no se pierda, va al final
        return cancion;
    }

    public static void main(String[] args) {
        Cola playlist = new Cola();
        playlist.enfilar("Hooked on a Feeling");
        playlist.enfilar("Go All the Way");
        playlist.enfilar("Spirit in the Sky");

        StringBuilder orden = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (i > 0) orden.append(" | ");
            orden.append(reproducirSiguiente(playlist));
        }
        Pruebas.verificar(orden.toString().equals(
                "Hooked on a Feeling | Go All the Way | Spirit in the Sky | "
                + "Hooked on a Feeling | Go All the Way | Spirit in the Sky | Hooked on a Feeling"),
                "la playlist se repite en bucle y en orden");
        Pruebas.verificar(playlist.largo() == 3, "no se pierde ninguna cancion");
        Pruebas.verificar(playlist.verPrimero().equals("Go All the Way"), "la siguiente en sonar es la 2da");
        Pruebas.verificar(playlist.verUltimo().equals("Hooked on a Feeling"), "la que acaba de sonar va al final");

        Cola vacia = new Cola();
        Pruebas.verificar(reproducirSiguiente(vacia) == null, "playlist vacia devuelve null");
        System.out.println("Desafio 2 OK -> la playlist suena en bucle sin perder canciones");
    }
}
