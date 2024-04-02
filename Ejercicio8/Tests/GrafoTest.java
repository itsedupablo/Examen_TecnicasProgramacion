package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import models.*;

class GrafoTest {

	// Test para probar si se agregan y eliminan las rutas correctamente
    @Test
    void testAgregarYEliminarRuta() {
        Puerto puerto1 = new Puerto(0, "Puerto1");
        Puerto puerto2 = new Puerto(1, "Puerto2");

        Grafo grafo = new Grafo(2);

        grafo.agregarRuta(puerto1, puerto2, 100);
        assertEquals(100, grafo.getMatrizAdyacencia()[0][1]);
        assertEquals(100, grafo.getMatrizAdyacencia()[1][0]);

        grafo.eliminarRuta(puerto1, puerto2);
        assertEquals(0, grafo.getMatrizAdyacencia()[0][1]);
        assertEquals(0, grafo.getMatrizAdyacencia()[1][0]);
    }

    // Test para probar el método de eliminar puerto con más aristas
    @Test
    void testEliminarPuertoConMasAristas() {
        Puerto puerto1 = new Puerto(0, "Puerto1");
        Puerto puerto2 = new Puerto(1, "Puerto2");
        Puerto puerto3 = new Puerto(2, "Puerto3");

        Grafo grafo = new Grafo(3);

        grafo.agregarRuta(puerto1, puerto2, 100);
        grafo.agregarRuta(puerto1, puerto3, 200);
        grafo.agregarRuta(puerto2, puerto3, 150);

        int puertoEliminado = grafo.eliminarPuertoConMasAristas();
        assertEquals(0, puertoEliminado);
        assertEquals(0, grafo.getMatrizAdyacencia()[0][1]);
        assertEquals(0, grafo.getMatrizAdyacencia()[0][2]);
        assertEquals(0, grafo.getMatrizAdyacencia()[1][0]);
        assertEquals(0, grafo.getMatrizAdyacencia()[1][2]);
        assertEquals(0, grafo.getMatrizAdyacencia()[2][0]);
        assertEquals(0, grafo.getMatrizAdyacencia()[2][1]);
    }

    //Test para probar el método de Dijkstra
    @Test
    void testDijkstra() {
        Puerto puerto1 = new Puerto(0, "Puerto1");
        Puerto puerto2 = new Puerto(1, "Puerto2");
        Puerto puerto3 = new Puerto(2, "Puerto3");

        Grafo grafo = new Grafo(3);

        grafo.agregarRuta(puerto1, puerto2, 100);
        grafo.agregarRuta(puerto1, puerto3, 200);
        grafo.agregarRuta(puerto2, puerto3, 150);

        grafo.dijkstra(0, 2); 
       
    }
}
