package test;

import static org.junit.Assert.*;

import org.junit.Test;

import user.*;
import models.*;

public class GestionBarcosTests {

	// Test para verificar si el barco se agregó correctamente a las tablas hash
	@Test
	public void testAgregarBarco() {
		Barco barco = new Barco(1, "Barco de prueba");
		GestionBarcos.addBarco(barco);

		assertEquals("El barco no se agregó correctamente a la tabla de tipo de barco", barco,
				GestionBarcos.tablaTipoBarco.get(GestionBarcos.funcionHash("Barco", GestionBarcos.MAXBARCOS)));

		assertEquals("El barco no se agregó correctamente a la tabla de número de barco", barco,
				GestionBarcos.tablaNumBarco.get(GestionBarcos.funcionHash(1, GestionBarcos.MAX_OTRAS_TABLAS)));

		assertEquals("El barco no se agregó correctamente a la tabla de nombre de barco", barco,
				GestionBarcos.tablaNombreBarco
						.get(GestionBarcos.funcionHash("Barco de prueba", GestionBarcos.MAX_OTRAS_TABLAS)));
	}

	// Test para verificar si la función hash funciona correctamente
	@Test
	public void testFuncionHash() {
		assertEquals(5, GestionBarcos.funcionHash("Prueba", 10));
		assertEquals(3, GestionBarcos.funcionHash(123, 5));
	}

	// Test para verificar si se crean los barcos correctamente
	@Test
	public void testCrearBarcos() {
		assertNotNull(GestionBarcos.battleshipFactory.crearBarco());
		assertNotNull(GestionBarcos.frigateFactory.crearBarco());
		assertNotNull(GestionBarcos.canoeFactory.crearBarco());
	}

	// Test para verificar si se maneja correctamente el límite de barcos
	@Test(expected = RuntimeException.class)
	public void testAgregarBarcoLimite() {
		for (int i = 0; i < 150; i++) {
			Barco barco = new Barco(i, "Barco " + i);
			GestionBarcos.addBarco(barco);
		}
	}

	// Test para verificar si se agrega un barco duplicado
	@Test
	public void testAgregarBarcoDuplicado() {
		
		Barco barco1 = new Barco(1, "Barco Duplicado");
		Barco barco2 = new Barco(1, "Barco Duplicado");

		GestionBarcos.addBarco(barco1);
		GestionBarcos.addBarco(barco2);

		
		assertEquals(barco1,
				GestionBarcos.tablaNumBarco.get(GestionBarcos.funcionHash(1, GestionBarcos.MAX_OTRAS_TABLAS)));
	}

}
