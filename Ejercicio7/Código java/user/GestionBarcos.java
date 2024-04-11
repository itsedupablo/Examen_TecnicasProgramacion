package user;

import java.util.*;
import factories.*;
import models.Barco;

public class GestionBarcos {
	// Constantes
	final static int MAXBARCOS = 100;
	final static int MAX_OTRAS_TABLAS = 15;

	// Tablas Hash
	public static HashMap<Integer, Barco> tablaTipoBarco = new HashMap<Integer, Barco>(MAXBARCOS);
	public static HashMap<Integer, Barco> tablaNumBarco = new HashMap<Integer, Barco>(MAX_OTRAS_TABLAS);
	public static HashMap<Integer, Barco> tablaNombreBarco = new HashMap<Integer, Barco>(MAX_OTRAS_TABLAS);

	// Fábricas
	final static ShipFactory battleshipFactory = new BattleShipFactory();
	final static ShipFactory frigateFactory = new FrigateFactory();
	final static ShipFactory canoeFactory = new CanoeFactory();

	// Función hash
	public static int funcionHash(Object clave, int tablaSize) {
	    int hash = 0;

	    if (clave == null) {
	        return 0; 
	    }

	    if (clave instanceof Integer) {
	        hash = (int) clave;
	    } else if (clave instanceof String) {
	        String claveString = (String) clave;
	        for (int i = 0; i < claveString.length(); i++) {
	            hash = 31 * hash + claveString.charAt(i);
	        }
	    } else {
	        hash = clave.hashCode();
	    }

	    return Math.abs(hash) % tablaSize;
	}


	public static void addBarco(Barco barco) {
	    String tipo = barco.getTipo();
	    int numero = barco.getNumBarco();
	    String nombre = barco.getNombre();

	    // Calcula el índice en la tabla utilizando la función hash
	    int indiceTipo = funcionHash(tipo, MAXBARCOS);
	    int indiceNumero = funcionHash(numero, MAX_OTRAS_TABLAS);
	    int indiceNombre = funcionHash(nombre, MAX_OTRAS_TABLAS);

	    // Agrega el barco a las tablas hash
	    tablaTipoBarco.putIfAbsent(indiceTipo, barco);
	    tablaNumBarco.putIfAbsent(indiceNumero,barco);
	    tablaNombreBarco.putIfAbsent(indiceNombre,barco);
	}
	
	// Método para mostrar las tablas
	public static void mostrarTablas() {
		System.out.println("Tabla por tipo de barco:");
		for (Map.Entry<Integer, Barco> entry : tablaTipoBarco.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("\nTabla por número de barco:");
		for (Map.Entry<Integer, Barco> entry : tablaNumBarco.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("\nTabla por nombre de barco:");
		for (Map.Entry<Integer, Barco> entry : tablaNombreBarco.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	// Método principal
	public static void main(String[] args) {
		Barco barco1 = battleshipFactory.crearBarco();
		Barco barco2 = frigateFactory.crearBarco();
		Barco barco3 = canoeFactory.crearBarco();
		Barco barco4 = new Barco(4,"");
		
		barco1.setNombre("Barco de guerra");
		barco1.setNumBarco(1);
		barco1.setNivel(1);
		barco2.setNombre("Fragata");
		barco2.setNumBarco(2);
		barco3.setNumBarco(3);
		barco4.setNombre("Barco 4");
		barco4.setNumBarco(4);
		barco4.setNivel(3);
		
		addBarco(barco1);
		addBarco(barco2);
		addBarco(barco3);
		addBarco(barco4);
		
		mostrarTablas();
	}

}
