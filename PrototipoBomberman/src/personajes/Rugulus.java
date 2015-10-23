package personajes;

import juego.Celda;
import juego.Tablero;

public class Rugulus extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 1;
	private final static int PUNTAJE = 15;

	public Rugulus(Celda celda, Tablero t) {

		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
	}
}
