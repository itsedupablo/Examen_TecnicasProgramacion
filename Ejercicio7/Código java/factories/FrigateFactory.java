package factories;

import models.*;

public class FrigateFactory implements ShipFactory {
	@Override
	public Barco crearBarco() {
		return new Frigate(3, "Frigate");
	}

}
