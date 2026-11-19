# Estructuras de Datos (Java) — Grupo 401M SIS

Trabajos de la materia, todos en Java y con pruebas incluidas en cada clase.

- `arreglos/` y `listas_enlazadas/`: 10 retos de la Masterclass *Arreglos vs Listas Enlazadas*.
- `pilas_y_colas/`: 7 desafios del Laboratorio *Pilas y Colas*.

## Estructura

```
arreglos/
├── Pruebas.java
└── Reto01BuscarIndice.java ... Reto05NumeroFaltante.java
listas_enlazadas/
├── Pruebas.java, Nodo.java, ListaUtil.java
└── Reto01InsertAtEnd.java ... Reto05DetectarBucle.java
pilas_y_colas/
├── Nodo.java, Pila.java, Cola.java        # clases base del laboratorio
├── Pruebas.java                           # utilidades de verificacion
├── PilaLimitada.java                      # clase del Desafio 1
├── ColaNebula.java                        # clase del Desafio 5
├── Sector.java                            # clase del Desafio 7
├── Desafio01CargadorRocket.java           # Pila con capacidad maxima
├── Desafio02WalkmanStarLord.java          # Cola ciclica (playlist en bucle)
├── Desafio03EnredoGroot.java              # Invertir una cola con una pila
├── Desafio04ArsenalDrax.java              # Buscar y extraer sin alterar el orden
├── Desafio05CerebroCibernetico.java       # Cola implementada con dos pilas
├── Desafio06BovedaColeccionista.java      # Ordenar una pila con una auxiliar
├── Desafio07DeflectoresMilano.java        # Simulador Round-Robin
└── EjecutarTodo.java                      # Ejecuta los 7 desafios
```

## Como compilar y ejecutar

Requiere JDK 11 o superior. Desde cada carpeta:

```bash
cd arreglos
javac *.java
java Reto01BuscarIndice

cd ../listas_enlazadas
javac *.java
java Reto01InsertAtEnd

cd ../pilas_y_colas
javac *.java
java EjecutarTodo          # los 7 desafios
java Desafio03EnredoGroot  # o uno solo
```

Si todo esta bien, cada reto o desafio imprime `... OK`.

## Pilas y Colas: resumen de los desafios

| # | Desafio | Idea clave | Complejidad |
|---|---------|------------|-------------|
| 1 | Pila limitada | `cantidadActual` vs `capacidadMaxima` al apilar | O(1) por operacion |
| 2 | Cola ciclica | sacar y volver a enfilar la cancion | O(1) |
| 3 | Invertir cola | pasar por una pila temporal | O(n) |
| 4 | Buscar y extraer | pila auxiliar para conservar el orden | O(n) |
| 5 | Cola con dos pilas | pila de entrada y pila de salida | enfilar O(1), sacar O(1) amortizado |
| 6 | Ordenar pila | una sola pila auxiliar, mayor en la cima | O(n^2) |
| 7 | Round-Robin | 10 unidades por turno, vuelve al final si falta | O(total / 10) |
