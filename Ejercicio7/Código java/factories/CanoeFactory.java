package factories;

import models.*;

public class CanoeFactory implements ShipFactory {

	// Método que crea un barco de tipo Canoe y lo retorna
	@Override
	public Barco crearBarco() {
		return new Canoe(1, "Canoe");
	}
}
