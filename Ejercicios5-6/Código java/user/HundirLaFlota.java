package user;

import models.*;
import factories.*;
import java.util.*;

public class HundirLaFlota {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    
        // Crear los jugadores
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        // Crear los tableros de juego
        Tablero tableroJugador1 = new Tablero(9);
        Tablero tableroJugador2 = new Tablero(9);
        
        // Inicializar los tableros
        tableroJugador1.inicializarTablero();
        tableroJugador2.inicializarTablero();

        // Colocar los barcos en los tableros de cada jugador
        crearBarcos(jugador1);
        crearBarcos(jugador2);
        tableroJugador1.colocarBarcos(jugador1.getBarcos());
        tableroJugador2.colocarBarcos(jugador2.getBarcos());

        while (!jugador1.haPerdido() && !jugador2.haPerdido()) {
            // Turno del jugador 1
            System.out.println("Turno del Jugador 1");
            realizarMovimiento(jugador1, tableroJugador2);

            // Verificar si el jugador 2 ha perdido
            if (jugador2.haPerdido()) {
                break; 
            }

            // Turno del jugador 2
            System.out.println("Turno del Jugador 2");
            realizarMovimiento(jugador2, tableroJugador1);

            // Verificar si el jugador 1 ha perdido
            if (jugador1.haPerdido()) {
                break; 
            }
        }

        // Determinar el ganador
        if (jugador1.haPerdido()) {
            System.out.println("¡El Jugador 2 ha ganado!");
            System.out.println("Tablero del jugador 1: ");
            tableroJugador1.mostrarTableroPropio();
            System.out.println("\n");
        } else {
            System.out.println("¡El Jugador 1 ha ganado!");
            System.out.println("Tablero del jugador 2: ");
            tableroJugador2.mostrarTableroPropio();
            System.out.println("\n");
        }
    }

    // Método para crear los barcos de cada jugador
    private static List<Barco> crearBarcos(Jugador jugador) {
      
        ShipFactory battleShipFactory = new BattleShipFactory();
        ShipFactory frigateFactory = new FrigateFactory();
        ShipFactory canoeFactory = new CanoeFactory();

        List<Barco> barcos = new ArrayList<Barco>();

        barcos.add(battleShipFactory.crearBarco());
        barcos.add(frigateFactory.crearBarco());
        barcos.add(frigateFactory.crearBarco());
        barcos.add(canoeFactory.crearBarco());
        barcos.add(canoeFactory.crearBarco());
        barcos.add(canoeFactory.crearBarco());

        for (Barco barco : barcos) {
            jugador.addBarco(barco);
        }
        return barcos;
    }

    // Método para realizar un movimiento de ataque
    public static void realizarMovimiento(Jugador atacante, Tablero tableroOponente) {
    	tableroOponente.mostrarTablero();
    	
    	boolean inputValido = false;
        int fila = 0;
        int columna = 0;

        while (!inputValido) {
            try {
                System.out.println("Ingresa las coordenadas del ataque (fila columna): ");
                fila = sc.nextInt();
                columna = sc.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Debe ingresar números enteros.");
                sc.next(); 
            }
        }


        if (fila < 0 || fila >= tableroOponente.getSize() || columna < 0 || columna >= tableroOponente.getSize()) {
            System.out.println("Coordenadas inválidas (se salen de rango). Inténtalo de nuevo.");
            realizarMovimiento(atacante, tableroOponente); 
            return;
        }

        char[][] tableroOponenteArray = tableroOponente.getTablero();
        if (tableroOponenteArray[fila][columna] == Tablero.OCUPADO) {
            System.out.println("¡Impacto! El ataque fue exitoso.");
          
            for (Barco barco : atacante.getBarcos()) {
                if (barco.recibirAtaque(fila, columna)) {
                    break; 
                }
            }
       
        } else {
            System.out.println("¡Agua! El ataque fue fallido.");
            
            tableroOponenteArray[fila][columna] = 'O'; 
            tableroOponente.setTablero(tableroOponenteArray);
        }
    }
}
