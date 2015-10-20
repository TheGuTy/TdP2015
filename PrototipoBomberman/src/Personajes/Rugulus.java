package Personajes;

import Juego.Celda;
import Juego.Tablero;

public class Rugulus extends Enemigo {
	
	private final static int VELOCIDAD_INICIAL = 1;
	private final static int PUNTAJE = 15;
	
	public Rugulus (Celda celda, Tablero t) {
		
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
	}

	@Override
	public void mover() {
		
		super.mover();
	}

	@Override
	public void matar() {
		
		
	}

}
