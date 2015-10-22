package personajes;

import juego.Celda;
import juego.Tablero;

public class Sirius extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 3;
	private final static int PUNTAJE = 50;
	
	public Sirius (Celda celda, Tablero t) {
		
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
	}

	@Override
	public void matar() {
		
		
	}
}
