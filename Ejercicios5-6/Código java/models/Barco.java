package models;
import java.util.Random;

public abstract class Barco {
	    private int size;
	    private int[] posicion; 
	    private boolean orientacion; // true para horizontal, false para vertical
	    private boolean hundido; 

	    // Constructor
	    public Barco(int size){
	        this.size = size;
	        posicion = new int[2];
	        orientacion = true;
	        this.hundido = false; 
	    }

	    // Getters y setters
	    public int getSize() {
	        return size;
	    }

	    public void setSize(int size) {
	        this.size = size;
	    }

	    public int[] getPosición() {
	        return posicion;
	    }

	    public void setPosición(int[] posición) {
	        this.posicion = posición;
	    }

	    public boolean isOrientacion() {
	        return orientacion;
	    }

	    public void setOrientacion(boolean orientacion) {
	        this.orientacion = orientacion;
	    }

	    public boolean isEstado() {
	        return hundido;
	    }

	    public void setEstado(boolean estado) {
	        this.hundido = estado;
	    }

	    // Método para verificar si el barco ha sido impactado
		public boolean recibirAtaque(int fila, int columna) {
			if (orientacion) {
				if (fila == posicion[0] && columna >= posicion[1] && columna < posicion[1] + size) {
					hundido = true;
					return true;
				}
			} else {
				if (columna == posicion[1] && fila >= posicion[0] && fila < posicion[0] + size) {
					hundido = true;
					return true;
				}
			}
			return false;
		}
	}
