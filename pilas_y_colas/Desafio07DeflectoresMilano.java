/**
 * Desafio 7 - Deflectores de la Milano (simulador Round-Robin).
 * Cada turno el nucleo entrega 10 unidades de energia al sector que esta
 * al frente de la cola. Si aun le falta energia vuelve al final de la cola;
 * si llego al 100% sale. Devuelve el total de turnos de energia entregados.
 */
public class Desafio07DeflectoresMilano {

    static final int ENERGIA_POR_CICLO = 10;

    public static int simularRoundRobin(Cola cola) {
        int turnos = 0;
        while (!cola.estaVacia()) {
            Sector sector = (Sector) cola.sacar();

            if (sector.energiaFaltante <= 0) {      // ya estaba al 100%: se descarta
                System.out.println(sector.nombre + " ya esta al 100%. Se descarta.");
                continue;
            }

            turnos++;
            sector.energiaFaltante -= ENERGIA_POR_CICLO;

            if (sector.energiaFaltante > 0) {
                System.out.println("Cargando " + sector.nombre + "... Restan "
                        + sector.energiaFaltante + " para el 100%");
                cola.enfilar(sector);               // espera un nuevo turno
            } else {
                sector.energiaFaltante = 0;
                System.out.println("Cargando " + sector.nombre
                        + "... Restan 0 para el 100%. " + sector.nombre + " al 100%!");
            }
        }
        return turnos;
    }

    public static void main(String[] args) {
        Sector frontal = new Sector("Frontal", 25);
        Sector trasero = new Sector("Trasero", 10);
        Sector izquierdo = new Sector("Izquierdo", 30);
        Sector derecho = new Sector("Derecho", 5);

        Cola cola = new Cola();
        cola.enfilar(frontal);
        cola.enfilar(trasero);
        cola.enfilar(izquierdo);
        cola.enfilar(derecho);

        final int[] turnos = new int[1];
        String salida = Pruebas.capturarSalida(() -> turnos[0] = simularRoundRobin(cola));
        System.out.print(salida);

        Pruebas.verificar(turnos[0] == 8, "Frontal 3 turnos + Trasero 1 + Izquierdo 3 + Derecho 1 = 8");
        Pruebas.verificar(cola.estaVacia(), "la cola termina vacia");
        Pruebas.verificar(frontal.energiaFaltante == 0 && trasero.energiaFaltante == 0
                && izquierdo.energiaFaltante == 0 && derecho.energiaFaltante == 0, "todos al 100%");
        Pruebas.verificar(salida.contains("Cargando Frontal... Restan 15 para el 100%"), "mensaje del primer turno de Frontal");
        Pruebas.verificar(salida.indexOf("Cargando Trasero") < salida.indexOf("Cargando Izquierdo"), "Trasero se atiende antes que Izquierdo");

        // Orden de atencion: F, T, I, D, F, I, F, I (turno circular)
        String[] nombres = {"Frontal", "Trasero", "Izquierdo", "Derecho", "Frontal", "Izquierdo", "Frontal", "Izquierdo"};
        String[] lineas = salida.trim().split("\\R");
        Pruebas.verificar(lineas.length == nombres.length, "una linea por turno");
        for (int i = 0; i < nombres.length; i++) {
            Pruebas.verificar(lineas[i].startsWith("Cargando " + nombres[i] + "..."), "turno " + (i + 1) + " atiende a " + nombres[i]);
        }

        // Casos borde
        Pruebas.verificar(simularRoundRobin(new Cola()) == 0, "cola vacia = 0 turnos");

        Cola conLleno = new Cola();
        conLleno.enfilar(new Sector("Lleno", 0));
        conLleno.enfilar(new Sector("Parcial", 4));
        Pruebas.verificar(Pruebas.capturarSalida(() -> Pruebas.verificar(simularRoundRobin(conLleno) == 1, "solo cuenta 1 turno")).contains("Lleno ya esta al 100%"),
                "un sector que ya esta al 100% se descarta sin recibir energia");
        System.out.println("Desafio 7 OK -> Round-Robin termina en 8 turnos con todos los sectores al 100%");
    }
}
