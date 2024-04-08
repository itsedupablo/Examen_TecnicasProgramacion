package models;

import java.util.*;

public class Jugador {
	private String nombre;
	private Tablero tablero;
	private List<Barco> barcos;

// Constructor
	public Jugador(String nombre) {
		this.nombre = nombre;
		barcos = new ArrayList<>();

	}

// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public List<Barco> getBarcos() {
		return barcos;
	}

	public void addBarco(Barco barco) {
		barcos.add(barco);
	
	}

// Método para verificar si el jugador ha perdido
	public boolean haPerdido() {
		for (Barco barco : barcos) {
			if (!barco.isEstado()) {
				return false;
			}
		}
		return true;
	}
}
