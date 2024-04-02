package models;

// Nodo del grafo
public class Puerto {
	private int id;
	private String nombre;

//Constructor
	public Puerto(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

//Getters
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
