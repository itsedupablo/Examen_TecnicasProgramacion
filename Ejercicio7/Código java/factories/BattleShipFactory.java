package factories;

import models.*;

public class BattleShipFactory implements ShipFactory {
	
	// Método que crea un barco de tipo Battleship y lo retorna
	@Override
	public Barco crearBarco() {
		return new Battleship(5, "Battleship");
	}
}
