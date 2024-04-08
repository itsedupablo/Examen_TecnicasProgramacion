package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import models.*;

public class HundirLaFlotaTest {

    // Test para comprobar la introducción de coordenadas válidas
    @Test
    public void testRealizarMovimientoCoordenadasValidas() {
        HundirLaFlota juego = new HundirLaFlota();
        Jugador jugador = new Jugador("Jugador Prueba");
        Tablero tablero = new Tablero(5);
        juego.realizarMovimiento(jugador, tablero, 2, 3);
        assertEquals(Tablero.OCUPADO, tablero.getTablero()[2][3]);
        
    }

    // Test para comprobar la introducción de coordenadas inválidas
    @Test
    public void testRealizarMovimientoCoordenadasInvalidas() {
        HundirLaFlota juego = new HundirLaFlota();
        Jugador jugador = new Jugador("Jugador Prueba");
        Tablero tablero = new Tablero(5);
    
        try {
            juego.realizarMovimiento(jugador, tablero, 6, 7); 
            fail("Se esperaba una excepción por coordenadas inválidas.");
        } catch (IllegalArgumentException e) {
            // La excepción esperada fue lanzada, el test pasa
        }
    }

    // Test para comprobar la creación de los barcos
    @Test
    public void testCrearBarcos() {
        HundirLaFlota juego = new HundirLaFlota();
        Jugador jugador = new Jugador("Jugador Prueba");
        List<Barco> barcos = juego.crearBarcos(jugador);
        assertNotNull(barcos);
        assertEquals(6, barcos.size());
        assertEquals(6, jugador.getBarcos().size());
    }
}
