/**
 * Desafio 3 - El Enredo de Groot (invertir una cola).
 * Una Pila invierte naturalmente el orden: se pasa todo de la cola a una
 * pila temporal y luego de la pila de vuelta a la cola.
 */
public class Desafio03EnredoGroot {

    public static void invertirCola(Cola cola) {
        Pila temp = new Pila();
        while (!cola.estaVacia()) {
            temp.apilar(cola.sacar());
        }
        while (!temp.estaVacia()) {
            cola.enfilar(temp.sacar());
        }
    }

    public static void main(String[] args) {
        Cola coordenadas = new Cola();
        for (int i = 1; i <= 5; i++) coordenadas.enfilar(i);
        invertirCola(coordenadas);
        Pruebas.verificar(coordenadas.verPrimero().equals(5), "el primero ahora es el ultimo original");
        Pruebas.verificar(coordenadas.verUltimo().equals(1), "el ultimo ahora es el primero original");
        Pruebas.verificar(coordenadas.largo() == 5, "no se pierden elementos");
        Pruebas.verificar(Pruebas.colaATexto(coordenadas).equals("5,4,3,2,1"), "orden invertido completo");

        Cola dos = new Cola();
        dos.enfilar("A");
        dos.enfilar("B");
        invertirCola(dos);
        Pruebas.verificar(Pruebas.colaATexto(dos).equals("B,A"), "cola de 2 elementos");

        Cola uno = new Cola();
        uno.enfilar(42);
        invertirCola(uno);
        Pruebas.verificar(uno.largo() == 1 && uno.verPrimero().equals(42) && uno.verUltimo().equals(42),
                "un solo elemento queda igual");

        Cola vacia = new Cola();
        invertirCola(vacia);
        Pruebas.verificar(vacia.estaVacia(), "cola vacia sigue vacia");

        // Despues de invertir, la cola sigue funcionando normalmente
        Cola c = new Cola();
        c.enfilar(1);
        c.enfilar(2);
        invertirCola(c);
        c.enfilar(3);
        Pruebas.verificar(Pruebas.colaATexto(c).equals("2,1,3"), "la cola sigue operativa tras invertirse");
        System.out.println("Desafio 3 OK -> {1, 2, 3, 4, 5} invertida = 5,4,3,2,1");
    }
}
