/**
 * Desafio 5 - El Cerebro Cibernetico (cola con dos pilas).
 * La clase ColaNebula esta en ColaNebula.java; aqui se prueba.
 */
public class Desafio05CerebroCibernetico {

    public static void main(String[] args) {
        // Orden FIFO basico
        ColaNebula cola = new ColaNebula();
        cola.enfilar(1);
        cola.enfilar(2);
        cola.enfilar(3);
        Pruebas.verificar(cola.largo() == 3, "tres elementos");
        Pruebas.verificar(cola.sacar().equals(1), "sale primero el 1 (FIFO)");
        Pruebas.verificar(cola.sacar().equals(2), "luego el 2");

        // Intercalar enfilar y sacar: el nuevo no se salta a los antiguos
        cola.enfilar(4);
        Pruebas.verificar(cola.sacar().equals(3), "sale el 3 antes que el 4");
        Pruebas.verificar(cola.sacar().equals(4), "sale el 4");
        Pruebas.verificar(cola.estaVacia(), "queda vacia");
        Pruebas.verificar(cola.sacar() == null, "sacar en cola vacia devuelve null");

        // Reutilizacion despues de vaciarse
        cola.enfilar("A");
        cola.enfilar("B");
        Pruebas.verificar(cola.sacar().equals("A"), "funciona tras haberse vaciado");
        cola.enfilar("C");
        Pruebas.verificar(cola.sacar().equals("B") && cola.sacar().equals("C"), "B y luego C");

        // Muchos elementos, mismo orden de entrada y salida
        ColaNebula grande = new ColaNebula();
        for (int i = 0; i < 100; i++) grande.enfilar(i);
        boolean ordenCorrecto = true;
        for (int i = 0; i < 100; i++) {
            if (!grande.sacar().equals(i)) ordenCorrecto = false;
        }
        Pruebas.verificar(ordenCorrecto && grande.estaVacia(), "100 elementos salen en el orden de entrada");
        System.out.println("Desafio 5 OK -> ColaNebula (dos pilas) respeta el orden FIFO");
    }
}
