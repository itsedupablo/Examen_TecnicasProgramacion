package models;

import java.util.Random;

// En este caso particular la clase barco no es abstracta para que se pueda instanciar y así definir barcos sin tipo específico
public class Barco { 
	private String tipo;
	private int numBarco;
	private String nombre;
	private int nivel;
	private int size;
	
	// Constructor
	public Barco(int size, String tipo) {
		this.size = size;
		if (!tipo.equals("Frigate") && !tipo.equals("Battleship") && !tipo.equals("Canoe")) {
			this.tipo = "Otros";
		} else {
			this.tipo = tipo;
		}
		numBarco = -1;
	}

	// Getters y setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	public int getNumBarco() {
		return numBarco;
	}
	
	public void setNumBarco(int numBarco) {
		this.numBarco = numBarco;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	// Método para asignar un número de barco único
	public void asignarNumBarcoUnico() {
        if (numBarco == -1) {
            numBarco = generarNumBarcoUnico();
        }
    }

    // Método para generar un número de barco único
    private int generarNumBarcoUnico() {
        return new Random().nextInt(1000);
    }

	
	// Método para obtener la información del barco
	@Override
	public String toString() {
		return "Barco{" + "tipo='" + tipo + '\'' + ", numBarco=" + numBarco + ", nombre='" + nombre + '\'' + ", nivel="
				+ nivel + ", size=" + size + '}';
	}
}
