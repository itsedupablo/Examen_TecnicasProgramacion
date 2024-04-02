package user;

import java.util.*;
import models.Grafo;
import models.Puerto;

public class Main {
    public static void main(String[] args) {
        // Crear puertos
        Puerto puerto0 = new Puerto(0, "Puerto0");
        Puerto puerto1 = new Puerto(1, "Madero"); // Puerto1
        Puerto puerto2 = new Puerto(2, "Puerto2");
        Puerto puerto3 = new Puerto(3, "Puerto3");
        Puerto puerto4 = new Puerto(4, "Rodas"); // Puerto4
        Puerto puerto5 = new Puerto(5, "Puerto5");
        Puerto puerto6 = new Puerto(6, "Puerto6");

        // Crear grafo
        Grafo grafo = new Grafo(7);

        // Agregar rutas
        grafo.agregarRuta(puerto0, puerto1, 200);
        grafo.agregarRuta(puerto0, puerto2, 317);
        grafo.agregarRuta(puerto0, puerto3, 120);
        grafo.agregarRuta(puerto1, puerto2, 150);
        grafo.agregarRuta(puerto1, puerto4, 1500);
        grafo.agregarRuta(puerto2, puerto3, 80);
        grafo.agregarRuta(puerto3, puerto5, 300);
        grafo.agregarRuta(puerto4, puerto5, 180);
        grafo.agregarRuta(puerto4, puerto6, 250);
        grafo.agregarRuta(puerto5, puerto6, 350);

        // Inicializar tabla de nombres de puertos
        grafo.setNombrePuerto(0, "Puerto0");
        grafo.setNombrePuerto(1, "Madero");
        grafo.setNombrePuerto(2, "Puerto2");
        grafo.setNombrePuerto(3, "Puerto3");
        grafo.setNombrePuerto(4, "Rodas");
        grafo.setNombrePuerto(5, "Puerto5");
        grafo.setNombrePuerto(6, "Puerto6");

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Obtener matriz de adyacencia");
            System.out.println("2. Realizar DFS");
            System.out.println("3. Realizar Dijkstra");
            System.out.println("4. Eliminar puerto con más aristas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nMatriz de adyacencia:");
                    int[][] matriz = grafo.getMatrizAdyacencia();
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            System.out.printf("%-5d", matriz[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("\nRecorrido en profundidad (DFS) desde el primer puerto:");
                    grafo.dfs(0);
                    break;
                case 3:
                    System.out.println("\n\nRuta más corta desde puerto Madero al puerto de Rodas:");
                    grafo.dijkstra(1, 4);
                    break;
                case 4:
                    System.out.println("\n\nEliminación del puerto con más rutas asociadas (nodo con más aristas):");
                    int idPuertoEliminado = grafo.eliminarPuertoConMasAristas();
                    if (idPuertoEliminado != -1) {
                        System.out.println("Se ha eliminado el puerto con el ID: " + idPuertoEliminado);
                    } else {
                        System.out.println("No se pudo eliminar ningún puerto.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }
}
