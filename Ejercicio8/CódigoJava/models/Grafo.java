package models;

import java.util.*;

public class Grafo {
	private int numPuertos;
	private Map<Integer, String> nombrePuertos;
	private int[][] matrizAdyacencia;
	

	// Constructor
	public Grafo(int numPuertos) {
		this.numPuertos = numPuertos;
		matrizAdyacencia = new int[numPuertos][numPuertos];
		nombrePuertos = new HashMap<>();
		
	}

	// Getters y Setters
	public int getNumPuertos() {
		return numPuertos;
	}

	public String getNombrePuerto(int idPuerto) {
        return nombrePuertos.get(idPuerto);
    }
	
	public void setNombrePuerto(int idPuerto, String nombre) {
		nombrePuertos.put(idPuerto, nombre);
	}
	
	
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	// Métodos para agregar y eliminar rutas (aristas)
	public void agregarRuta(Puerto origen, Puerto destino, int distancia) {
		matrizAdyacencia[origen.getId()][destino.getId()] = distancia;
		matrizAdyacencia[destino.getId()][origen.getId()] = distancia; // Para grafo no dirigido
	}

	public void eliminarRuta(Puerto origen, Puerto destino) {
		matrizAdyacencia[origen.getId()][destino.getId()] = 0;
		matrizAdyacencia[destino.getId()][origen.getId()] = 0; // Para grafo no dirigido
	}

	// Método para obtener los puertos adyacentes a un puerto dado
	private List<Puerto> obtenerPuertosAdyacentes(Puerto puerto) {
		List<Puerto> adyacentes = new ArrayList<>();
		int idPuerto = puerto.getId();
		for (int i = 0; i < numPuertos; i++) {
			if (matrizAdyacencia[idPuerto][i] != 0) {
				adyacentes.add(new Puerto(i, nombrePuertos.get(i))); // Supongamos que los puertos tienen nombres genéricos
			}
		}
		return adyacentes;
	}

	// Método para realizar el barrido en profundidad (DFS)
	public void dfs(int inicio) {
	    boolean[] visitado = new boolean[numPuertos];
	    Stack<Integer> stack = new Stack<>();

	    stack.push(inicio);
	    visitado[inicio] = true;

	    while (!stack.isEmpty()) {
	        int actual = stack.pop();
	        System.out.print(nombrePuertos.get(actual));

	        // Obtener los puertos adyacentes al puerto actual
	        List<Puerto> adyacentes = obtenerPuertosAdyacentes(new Puerto(actual, nombrePuertos.get(actual)));

	        // Iterar sobre los puertos adyacentes
	        for (Puerto adyacente : adyacentes) {
	            int idPuertoAdyacente = adyacente.getId();
	            if (!visitado[idPuertoAdyacente]) {
	                stack.push(idPuertoAdyacente);
	                visitado[idPuertoAdyacente] = true;
	            }
	        }

	        if (!stack.isEmpty()) {
	            System.out.print(" ---> ");
	        }
	    }
	}
	
	// Método para realizar el algoritmo de Dijkstra y así encontrar el camino más corto entre dos puertos
	public void dijkstra(int origen, int destino) {
        int[] distancias = new int[numPuertos];
        boolean[] visitados = new boolean[numPuertos];
        int[] predecesores = new int[numPuertos];

        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);

        distancias[origen] = 0;

     
        for (int i = 0; i < numPuertos - 1; i++) {
            int nodoActual = nodoConDistanciaMinima(distancias, visitados);

            visitados[nodoActual] = true;

           
            for (int j = 0; j < numPuertos; j++) {
                if (!visitados[j] && matrizAdyacencia[nodoActual][j] != 0 && distancias[nodoActual] != Integer.MAX_VALUE &&
                        distancias[nodoActual] + matrizAdyacencia[nodoActual][j] < distancias[j]) {
                    distancias[j] = distancias[nodoActual] + matrizAdyacencia[nodoActual][j];
                    predecesores[j] = nodoActual;
                }
            }
        }

        
        int nodo = destino;
        Stack<Integer> ruta = new Stack<>();
        while (nodo != -1) {
            ruta.push(nodo);
            nodo = predecesores[nodo];
        }
        while (!ruta.isEmpty()) {
            System.out.print(ruta.pop() + " ");
        }
        System.out.println("con una distancia total de " + distancias[destino]);
    }

	// Método auxiliar para obtener el nodo con la menor distancia
    private int nodoConDistanciaMinima(int[] distancias, boolean[] visitados) {
        int minDistancia = Integer.MAX_VALUE;
        int minNodo = -1;

        for (int i = 0; i < numPuertos; i++) {
            if (!visitados[i] && distancias[i] < minDistancia) {
                minDistancia = distancias[i];
                minNodo = i;
            }
        }

        return minNodo;
    }

    public int eliminarPuertoConMasAristas() {
        int maxAristas = 0;
        int puertoMaxAristas = -1;

        for (int i = 0; i < numPuertos; i++) {
            int aristas = 0;
            for (int j = 0; j < numPuertos; j++) {
                if (matrizAdyacencia[i][j] != 0) {
                    aristas++;
                }
            }
            if (aristas > maxAristas) {
                maxAristas = aristas;
                puertoMaxAristas = i;
            }
        }

        if (puertoMaxAristas != -1) {
            for (int i = 0; i < numPuertos; i++) {
                matrizAdyacencia[puertoMaxAristas][i] = 0;
                matrizAdyacencia[i][puertoMaxAristas] = 0;
            }
            numPuertos--;

            return puertoMaxAristas;
        } else {
            System.out.println("No se encontró ningún puerto para eliminar.");
            return -1; 
        }
    }

}