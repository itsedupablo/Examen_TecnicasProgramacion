package models;

import java.util.*;

public class Tablero {
	private char[][] tablero;
	private int size;
	public static final char VACIO = '~';
	public static final char OCUPADO = '*';

	// Constructor
	public Tablero(int size) {
		this.size = size;
		this.tablero = new char[size][size];
		inicializarTablero();
	}

	// Getters y setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;

	}

	// Método para inicializar el tablero
	public void inicializarTablero() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}

	// Método para colocar los barcos en el tablero
	public void colocarBarcos(List<Barco> barcos) {
		Random rand = new Random();
		for (Barco barco : barcos) {
			boolean posicionado = false;
			while (!posicionado) {
				int fila = rand.nextInt(size);
				int columna = rand.nextInt(size);
				boolean orientacionHorizontal = rand.nextBoolean();
				if (verificarEspacioDisponible(fila, columna, barco.getSize(), orientacionHorizontal)) {
					// Posicionar el barco en el tablero
					posicionarBarco(fila, columna, barco.getSize(), orientacionHorizontal);
					posicionado = true;
				}
			}
		}
	}

	// Método auxiliar para verificar si hay espacio disponible para un barco
	private boolean verificarEspacioDisponible(int fila, int columna, int size, boolean orientacionHorizontal) {
		if (orientacionHorizontal) {
			if (columna + size > size) {
				return false;
			}
			for (int i = columna; i < columna + size; i++) {
				if (tablero[fila][i] == OCUPADO) {
					return false;
				}
			}
		} else {
			if (fila + size > size) {
				return false;
			}
			for (int i = fila; i < fila + size; i++) {
				if (tablero[i][columna] == OCUPADO) {
					return false;
				}
			}
		}
		return true;
	}

	// Método auxiliar para posicionar un barco en el tablero
	private void posicionarBarco(int fila, int columna, int size, boolean orientacionHorizontal) {
		if (orientacionHorizontal) {
			for (int i = columna; i < columna + size; i++) {
				tablero[fila][i] = OCUPADO;
			}
		} else {
			for (int i = fila; i < fila + size; i++) {
				tablero[i][columna] = OCUPADO;
			}
		}
	}

	// Getters y setters
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	// Método para imprimir el tablero (del contrincante) en consola
	public void mostrarTablero() {
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	            char estado = tablero[i][j];
	            if (estado == OCUPADO) {
	                // Si la celda contiene un barco, mostrar '~' para ocultar la ubicación
	                System.out.print(VACIO + " ");
	            } else {
	                // Mostrar el estado actual de la celda (impacto o agua)
	                System.out.print(estado + " ");
	            }
	        }
	        System.out.println();
	    }
	}

	
	public void mostrarTableroPropio() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
}
